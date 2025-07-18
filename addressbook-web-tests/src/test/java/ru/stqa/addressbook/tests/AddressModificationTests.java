package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.manager.AddressHelper;
import ru.stqa.addressbook.manager.HibernateHelper;
import ru.stqa.addressbook.models.AddressData;
import static ru.stqa.addressbook.comporators.AddressComparators.byId;

import java.util.ArrayList;
import java.util.Random;
public class AddressModificationTests extends TestBase {
    @Test
    void canModifyAddress() {
        AddressHelper address = app.address();
        HibernateHelper hbm = app.hbm();

        if (hbm.getContactList().isEmpty()) {
            address.createAddress(new AddressData(), null);
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

        newAddresses.sort(byId);
        expectedList.sort(byId);

        Assertions.assertEquals(newAddresses, expectedList);

    }
    @Test
    void cannotModifyAddress() {
        AddressHelper address = app.address();
        HibernateHelper hbm = app.hbm();

        if (hbm.getContactsCount()==0) {
            address.createAddress(new AddressData(), null);
        }

        var oldAddress = hbm.getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldAddress.size());

        var testData = new AddressData().withFirstname("modified' name");

        address.modifyAddress(oldAddress.get(index), testData);

        var newAddress = hbm.getContactList();

        newAddress.sort(byId);
        oldAddress.sort(byId);

        Assertions.assertEquals(oldAddress, newAddress);
    }
}