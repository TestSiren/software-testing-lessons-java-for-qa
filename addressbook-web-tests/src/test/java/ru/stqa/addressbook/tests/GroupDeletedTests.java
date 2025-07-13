package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.models.GroupData;
import ru.stqa.addressbook.manager.GroupHelper;
import ru.stqa.addressbook.manager.HibernateHelper;

import java.util.ArrayList;
import java.util.Random;

public class GroupDeletedTests extends TestBase {
  @Test
  public void groupsDeletedTests() {
    HibernateHelper hbm = app.hbm();
    GroupHelper groups = app.groups();

    if (hbm.getGroupsCount() == 0) {
      hbm.createGroup(new GroupData().withName("some name"));
    }

    var oldGroups = hbm.getGroupList();

    var rnd = new Random();
    var index = rnd.nextInt(oldGroups.size());

    groups.deleteElement(oldGroups.get(index));
    var newGroups = hbm.getGroupList();

    var expectedList = new ArrayList<>(oldGroups);
    expectedList.remove(index);

    Assertions.assertEquals(newGroups, expectedList);
  }

  @Test
  public void canRemoveAllGroupsAtOnce() {
    HibernateHelper hbm = app.hbm();
    GroupHelper groups = app.groups();

    if (hbm.getGroupsCount() == 0) {
      hbm.createGroup(new GroupData().withName("some name"));
    }
    var oldGroups = hbm.getGroupList();

    groups.deleteAllGroup();

    var newGroups = hbm.getGroupList();

    var expectedList = new ArrayList<>(oldGroups);
    expectedList.clear();

    Assertions.assertEquals(newGroups, expectedList);

    Assertions.assertEquals(0, hbm.getGroupsCount());
  }
}
