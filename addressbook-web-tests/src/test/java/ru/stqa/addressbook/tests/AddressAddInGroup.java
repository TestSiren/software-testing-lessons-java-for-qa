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
import java.util.List;

import static ru.stqa.addressbook.comporators.AddressComparators.byId;


public class AddressAddInGroup extends TestBase {
    @Test
    public void addressAddToGroup() {
        AddressHelper addresses = app.address();
        GroupHelper groups = app.groups();
        HibernateHelper hbm = app.hbm();
        //обеспечение предусловий
        if (hbm.getContactsCount()==0) {
            addresses.createAddress(new AddressData(), null);
        }
        if (hbm.getGroupsCount() == 0) {
            hbm.createGroup(new GroupData().withName("some name"));
        }
        var oldAddress = hbm.getContactList();
        var group = hbm.getGroupList().get(0);
        var oldRelated = hbm.getContactsInGroup(group);
        oldRelated.sort(byId);
        //добавление
        addresses.addressesAddToGroup(oldAddress, group);

        var newRelated = hbm.getContactsInGroup(group);
        newRelated.sort(byId);
        Assertions.assertEquals(newRelated, oldRelated);
                //постусловие
    }
}
