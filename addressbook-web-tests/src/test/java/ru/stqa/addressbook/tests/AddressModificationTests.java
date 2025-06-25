package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import ru.stqa.addressbook.manager.GroupHelper;
import ru.stqa.addressbook.models.GroupData;

import java.util.ArrayList;
import java.util.Random;

import static ru.stqa.addressbook.comporators.GroupComporators.compareById;

public class AddressModificationTests {
//    void canModifyGroup() {
//        GroupHelper groups = app.groups();
//        if (groups.getGroupsCount() == 0) {
//            groups.createGroup(new GroupData("", "group name", "group header", "group footer"));
//        }
//
//        var oldGroups = groups.getListGroups();
//        var rnd = new Random();
//        var index = rnd.nextInt(oldGroups.size());
//        var testData = new GroupData().withName("modified name");
//
//        groups.modifyGroup(oldGroups.get(index), testData);
//
//        var newGroups = groups.getListGroups();
//        var expectedList = new ArrayList<>(oldGroups);
//        expectedList.set(index, testData.withId(oldGroups.get(index).id()));
//
//        newGroups.sort(compareById);
//        expectedList.sort(compareById);
//
//        Assertions.assertEquals(newGroups, expectedList);
//    }
}
