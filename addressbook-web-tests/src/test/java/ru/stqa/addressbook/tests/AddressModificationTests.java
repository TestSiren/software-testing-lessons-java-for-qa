package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.models.AddressData;
import ru.stqa.addressbook.manager.AddressHelper;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.stqa.addressbook.comporators.AddressComparators.byFirstAndLastName;
import static ru.stqa.addressbook.manager.AddressHelper.equalsByNamesAndId;

import java.util.ArrayList;
import java.util.Random;
public class AddressModificationTests extends TestBase {
    @Test
    @Disabled
    void canModifyAddress() {
        AddressHelper address = app.address();
        if (address.getAddressCount() == 0) {
            address.createAddress(new AddressData());
        }

        var oldAddress = address.getListAddress();
        var rnd = new Random();
        var index = rnd.nextInt(oldAddress.size());
        var old = oldAddress.get(index);
        var testData = new AddressData().withId(old.id())
                .withFirstname("New First Name")
                .withMiddlename(old.middlename())
                .withLastname(old.lastname())
                .withNickname(old.nickname())
                .withTitle(old.title())
                .withCompany(old.company())
                .withAddress(old.address())
                .withHome(old.home())
                .withMobile(old.mobile())
                .withWork(old.work())
                .withFax(old.fax())
                .withHomepage(old.homepage())
                .withEmail(old.emails())
                .withBday(old.bday())
                .withBmonth(old.bmonth())
                .withByear(old.byear())
                .withAday(old.aday())
                .withAmonth(old.amonth())
                .withAyear(old.ayear())
                .withGroup(old.group());

        address.modifyAddress(old, testData);

        var newAddresses = address.getListAddress();
        var expectedList = new ArrayList<>(oldAddress);
        expectedList.set(index, testData.withId(old.id()));

        newAddresses.sort(byFirstAndLastName);
        expectedList.sort(byFirstAndLastName);

        assertTrue(equalsByNamesAndId(newAddresses, expectedList));

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

