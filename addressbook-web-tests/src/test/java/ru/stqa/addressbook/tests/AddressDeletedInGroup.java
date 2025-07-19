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


public class AddressDeletedInGroup extends TestBase {

    @Test
    public void addressesWithGroupDeleted() {
        AddressHelper addresses = app.address();
        GroupHelper groups = app.groups();
        HibernateHelper hbm = app.hbm();

        // Проверяем есть ли группы, если нет — создаём
        if (hbm.getGroupsCount() == 0) {
            GroupData newGroup = new GroupData().withName("Default Group");
            hbm.createGroup(newGroup);
        }

        // Обновляем список групп
        var allGroups = hbm.getGroupList();

        GroupData groupWithContacts = null;
        List<AddressData> contactsInGroup = null;

        // Ищем группу, в которой есть контакты
        for (GroupData group : allGroups) {
            contactsInGroup = hbm.getContactsInGroup(group);
            if (!contactsInGroup.isEmpty()) {
                groupWithContacts = group;
                break;
            }
        }

        // Если ни в одной группе нет контактов — создаём контакт в первой группе
        if (groupWithContacts == null) {
            groupWithContacts = allGroups.get(0);
            AddressData contact = new AddressData().withFirstname("Test").withLastname("User");
            addresses.createAddress(contact, groupWithContacts);
            contactsInGroup = hbm.getContactsInGroup(groupWithContacts);
        }

        // Теперь удаляем все контакты из найденной группы
        addresses.removeAddressesFromGroup(contactsInGroup, groupWithContacts);

        // Проверяем, что контактов в группе больше нет
        var contactsAfterRemoval = hbm.getContactsInGroup(groupWithContacts);
        Assertions.assertTrue(contactsAfterRemoval.isEmpty(),
                "Группа должна быть пустой после удаления всех контактов");

        System.out.println("Удалены все контакты из группы: " + groupWithContacts.name());
    }
}