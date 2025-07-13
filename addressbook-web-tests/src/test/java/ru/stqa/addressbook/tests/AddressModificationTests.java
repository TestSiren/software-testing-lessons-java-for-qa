package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.models.AddressData;
import ru.stqa.addressbook.manager.AddressHelper;
import static ru.stqa.addressbook.comporators.AddressComparators.byFirstAndLastName;

import java.util.ArrayList;
import java.util.Random;
public class AddressModificationTests extends TestBase {
    @Test
    void canModifyAddress() {
        AddressHelper address = app.address();
        if (address.getAddressCount() == 0) {
            address.createAddress(new AddressData());
        }

        var oldAddress = address.getListAddress();
        var rnd = new Random();
        var index = rnd.nextInt(oldAddress.size());
        var testData = new AddressData().withFirstname("modified name");

        address.modifyAddress(oldAddress.get(index), testData);

        var newAddresses = address.getListAddressGir cherry-pick commit hash();
        var expectedList = new ArrayList<>(oldAddress);
        expectedList.set(index, testData.withId(oldAddress.get(index).id()));

        newAddresses.sort(byFirstAndLastName);
        expectedList.sort(byFirstAndLastName);

        for (int i = 0; i < expectedList.size(); i++) {
            Assertions.assertEquals(expectedList.get(i).firstname(), newAddresses.get(i).firstname());
            Assertions.assertEquals(expectedList.get(i).lastname(), newAddresses.get(i).lastname());
        }
        Assertions.assertEquals(newAddresses, expectedList);

    }
    @Test
    void cannotModifyAddress() {
        AddressHelper address = app.address();
        if (address.getAddressCount() == 0) {
            address.createAddress(new AddressData());
        }

        var oldAddress = address.getListAddress();
        var rnd = new Random();
        var index = rnd.nextInt(oldAddress.size());
        var testData = new AddressData().withFirstname("modified' name");

        address.modifyAddress(oldAddress.get(index), testData);

        var newAddress = address.getListAddress();

        Assertions.assertEquals(oldAddress, newAddress);
    }
}
