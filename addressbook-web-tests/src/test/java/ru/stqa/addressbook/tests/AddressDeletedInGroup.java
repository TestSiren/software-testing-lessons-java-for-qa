package ru.stqa.addressbook.tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.manager.AddressHelper;
import ru.stqa.addressbook.manager.GroupHelper;
import ru.stqa.addressbook.models.AddressData;
import ru.stqa.addressbook.models.GroupData;
import ru.stqa.addressbook.manager.HibernateHelper;
import ru.stqa.addressbook.common.CommonFunctions;

import java.util.ArrayList;
import java.util.Random;

import static ru.stqa.addressbook.comporators.AddressComparators.byId;


public class AddressDeletedInGroup extends TestBase {

    @Test
    public void addressesWithGroupAddToGroupB() {
        AddressHelper addresses = app.address();
        GroupHelper groups = app.groups();
        HibernateHelper hbm = app.hbm();

        GroupData groupA = groups.getOrCreateGroup("Group A");
        GroupData groupB = groups.getOrCreateGroup("Group B");

        // создаём контакт в группе A
        AddressData contact = new AddressData().withFirstname("Test").withLastname("User");
        addresses.createAddress(contact, groupA);

        // получаем контакты в A
        var oldRelated = hbm.getContactsInGroup(groupA);
        oldRelated.sort(byId);

        // переносим контакты с удалением из А в группу B
        addresses.removeAddressesFromGroup(oldRelated, groupA);
        addresses.addressAddToGroup(contact, groupB, "[none]");


        // получаем контакты в группе B
        var newRelated = hbm.getContactsInGroup(groupB);
        newRelated.sort(byId);

        // формируем ожидаемый результат
        var expectedList = new ArrayList<>(oldRelated);
        for (int i = 0; i < expectedList.size(); i++) {
            expectedList.set(i, expectedList.get(i).withGroup(groupB.name()));
        }
        expectedList.sort(byId);

        Assertions.assertEquals(expectedList, newRelated);
        System.out.println("expectedList: " + expectedList + "\nnewRelated: " + newRelated);
    }
}