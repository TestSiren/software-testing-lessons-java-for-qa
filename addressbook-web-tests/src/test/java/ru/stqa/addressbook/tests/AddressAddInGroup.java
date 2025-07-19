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
import java.util.Random;

import static ru.stqa.addressbook.comporators.AddressComparators.byId;


public class AddressAddInGroup extends TestBase {
    @Test
    public void oneRandomAddressAddToGroup() {
        AddressHelper addresses = app.address();
        GroupHelper groups = app.groups();
        HibernateHelper hbm = app.hbm();

        if (hbm.getGroupsCount() == 0) {
            hbm.createGroup(new GroupData().withName("some name"));
        }
        if (hbm.getCountContactsWithoutGroup()==0){
            addresses.createAddress(new AddressData(), null);
        }

        var oldAddress = hbm.getContactsWithoutGroup();

        var list_groups = hbm.getGroupList();

        var rnd = new Random();
        var rndGroup = rnd.nextInt(list_groups.size());
        var group = list_groups.get(rndGroup);

        var rndContact = rnd.nextInt(oldAddress.size());
        var address = oldAddress.get(rndContact);

        var oldRelated = hbm.getContactsInGroup(group);
        oldRelated.sort(byId);

        var filter = "[none]";
        addresses.addressAddToGroup(address, group, filter);

        var newRelated = hbm.getContactsInGroup(group);
        newRelated.sort(byId);

        var expectedList = new ArrayList<>(oldRelated);
        var modifiedContact = address.withGroup(group.name());
        expectedList.add(modifiedContact);

        expectedList.sort(byId);

        Assertions.assertEquals(expectedList, newRelated);
        System.out.println("expectedList: " + expectedList + "\nnewRelated: " + newRelated);
    }

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

        // получаем контакты в группах до изменений
        var oldRelatedA = hbm.getContactsInGroup(groupA);
        var oldRelatedB = hbm.getContactsInGroup(groupB);
        oldRelatedA.sort(byId);
        oldRelatedB.sort(byId);

        // выбираем контакт для перемещения
        AddressData toMove = oldRelatedA.get(0);

        // удаляем из группы А
        addresses.removeAddressesFromGroup(List.of(toMove), groupA);

        // добавляем в группу B
        addresses.addressAddToGroup(toMove, groupB, "[none]");

        // получаем актуальные списки
        var newRelatedA = hbm.getContactsInGroup(groupA);
        var newRelatedB = hbm.getContactsInGroup(groupB);
        newRelatedA.sort(byId);
        newRelatedB.sort(byId);

        // формируем ожидаемые списки
        var expectedRelatedA = new ArrayList<>(oldRelatedA);
        expectedRelatedA.remove(toMove);
        expectedRelatedA.sort(byId);

        var expectedRelatedB = new ArrayList<>(oldRelatedB);
        expectedRelatedB.add(toMove.withGroup(groupB.name()));
        expectedRelatedB.sort(byId);

        // проверки
        Assertions.assertEquals(expectedRelatedA, newRelatedA, "Group A after removal");
        Assertions.assertEquals(expectedRelatedB, newRelatedB, "Group B after addition");
    }

}
