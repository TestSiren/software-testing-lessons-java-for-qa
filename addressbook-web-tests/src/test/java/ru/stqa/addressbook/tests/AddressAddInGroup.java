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
    public void addressWithGroupAddToGroupB() {
        AddressHelper addresses = app.address();
        GroupHelper groups = app.groups();
        HibernateHelper hbm = app.hbm();

        //есть 2 группы?  нет -> создать
        if (hbm.getGroupsCount() <= 1) {
            hbm.createGroup(new GroupData().withName("some name"));
        }
        //есть контакты? нет -> создать, да -> Проверить в группе ли они. Если не в группе, то добавить.


        //получаем "старый список"
        var oldAddress = hbm.getContactsWithoutGroup();

        //получаем список групп
        var list_groups = hbm.getGroupList();

        //нужно проверить что контакт не в группе А. Если в группе А, взять Б, если в Б, взять А
        var rnd = new Random();
        var rndGroup = rnd.nextInt(list_groups.size());
        var group = list_groups.get(rndGroup);


        var rndContact = rnd.nextInt(oldAddress.size());
        var address = oldAddress.get(rndContact);

        var oldRelated = hbm.getContactsInGroup(group);
        oldRelated.sort(byId);

        // меняем группу контакту
        var filter = "[none]";
        addresses.addressAddToGroup(address, group, filter);

        var newRelated = hbm.getContactsInGroup(group);
        newRelated.sort(byId);

        // формируем ожидаемый результат
        var expectedList = new ArrayList<>(oldRelated);
        var modifiedContact = address.withGroup(group.name());
        expectedList.add(modifiedContact);

        expectedList.sort(byId);
// постусловие
        Assertions.assertEquals(expectedList, newRelated);
        System.out.println("expectedList: " + expectedList + "\nnewRelated: " + newRelated);
    }
}
