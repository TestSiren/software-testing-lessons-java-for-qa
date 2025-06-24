package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.models.GroupData;
import ru.stqa.addressbook.manager.GroupHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
public class GroupModificationTests extends TestBase {
    @Test
    void canModifyGroup() {
        GroupHelper groups = app.groups();
        if (groups.getGroupsCount() == 0) {
            groups.createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var oldGroups = groups.getListGroups();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        var testData = new GroupData().withName("modified name");
        groups.modifyGroup(oldGroups.get(index), testData);
        var newGroups = groups.getListGroups();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index, testData.withId(oldGroups.get(index).id()));
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);
    }
}
