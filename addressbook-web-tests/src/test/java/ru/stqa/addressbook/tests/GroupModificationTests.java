package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.models.GroupData;
import ru.stqa.addressbook.manager.GroupHelper;
import static ru.stqa.addressbook.comporators.GroupComporators.compareById;
import ru.stqa.addressbook.manager.HibernateHelper;
import java.util.ArrayList;
import java.util.Random;

public class GroupModificationTests extends TestBase {
    @Test
    void canModifyGroup() {
        GroupHelper groups = app.groups();
        if (groups.getGroupsCount() == 0) {
            groups.createGroup(new GroupData("", "group name", "group header", "group footer"));
        }

        HibernateHelper hbm = app.hbm();

        var oldGroups = hbm.getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        var testData = new GroupData().withName("modified name");

        groups.modifyGroup(oldGroups.get(index), testData);

        var newGroups = groups.getListGroups();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.set(index, testData.withId(oldGroups.get(index).id()));

        newGroups.sort(compareById);
        expectedList.sort(compareById);

        Assertions.assertEquals(newGroups, expectedList);
    }
    @Test
    void cannotModifyGroup() {
        GroupHelper groups = app.groups();
        if (groups.getGroupsCount() == 0) {
            groups.createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        HibernateHelper hbm = app.hbm();
        var oldGroups =  hbm.getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        var testData = new GroupData().withName("modified' name");

        groups.modifyGroup(oldGroups.get(index), testData);

        var newGroups = hbm.getGroupList();

        Assertions.assertEquals(newGroups, oldGroups);
    }
}