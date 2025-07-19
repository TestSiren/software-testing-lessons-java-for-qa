package ru.stqa.addressbook.tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.manager.AddressHelper;
import ru.stqa.addressbook.manager.GroupHelper;
import ru.stqa.addressbook.models.AddressData;
import ru.stqa.addressbook.models.GroupData;
import ru.stqa.addressbook.manager.HibernateHelper;

import java.util.ArrayList;
import java.util.Random;

import static ru.stqa.addressbook.comporators.AddressComparators.byId;


public class AddressAddInGroup extends TestBase {
    @Test
    public void addressAddToGroup() {
        AddressHelper addresses = app.address();
        GroupHelper groups = app.groups();
        HibernateHelper hbm = app.hbm();

        //обеспечение предусловий
        if (hbm.getContactsCountWithGroup()==0) {
            if (hbm.getContactsCount() == 0) {
                addresses.createAddress(new AddressData(), null);
            }
            if (hbm.getGroupsCount() == 0) {
                hbm.createGroup(new GroupData().withName("some name"));
            }
        }

        var oldAddress = hbm.getContactList();

        var list_groups = hbm.getGroupList();
        var rnd = new Random();
        var rndGroup = rnd.nextInt(list_groups.size());
        var group = list_groups.get(rndGroup);

        var oldRelated = hbm.getContactsInGroup(group);
        oldRelated.sort(byId);
        //добавление
        addresses.addressesAddToGroup(oldAddress, group);
        System.out.println("group" + group);
        var newRelated = hbm.getContactsInGroup(group);
        newRelated.sort(byId);
        //формируем ожидаемый результат

        var expectedList = new ArrayList<>(oldRelated);
        AddressData contactToAdd = null;
        for (AddressData contact : oldAddress) {
            if (!oldRelated.contains(contact)) {
                contactToAdd = contact;
                break;
            }
        }
        if (contactToAdd != null) {
            AddressData modifiedContact = contactToAdd.withGroup(group.name());
            expectedList.add(modifiedContact);
        }

        expectedList.sort(byId);




        Assertions.assertEquals(newRelated, oldRelated);
        System.out.println("oldRelated: " + oldRelated + "\n newRelated: " + newRelated);

        //постусловие

    }
}
