package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.manager.AddressHelper;
import ru.stqa.addressbook.manager.HibernateHelper;
import ru.stqa.addressbook.models.AddressData;
import static ru.stqa.addressbook.comporators.AddressComparators.byId;


import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeletedAddressBook extends TestBase {
  @Test
  public void deleteSingleAddressTest() {
    AddressHelper address = app.address();
    HibernateHelper hbm = app.hbm();

    if (hbm.getContactList().isEmpty()) {
      address.createAddress(new AddressData(), null);
    }

    var oldAddress= hbm.getContactList();
    oldAddress.sort(byId);
    var rnd = new Random();
    var index = rnd.nextInt(oldAddress.size());

    address.deleteAddress(oldAddress.get(index));
    var newAddresses= hbm.getContactList();
    newAddresses.sort(byId);

    var expectedList = new ArrayList<>(oldAddress);
    expectedList.remove(index);
    expectedList.sort(byId);

    assertFalse(address.acceptAlertIfPresent(), "Allert не показывается, если была хотя бы одна запись");
    Assertions.assertEquals(newAddresses, expectedList);
  }

  @Test
  public void deleteAllAddressesTest() {
    AddressHelper address = app.address();
    HibernateHelper hbm = app.hbm();

    if (hbm.getContactsCount()==0) {
      address.createAddress(new AddressData(), null);}

    var oldAddress= hbm.getContactList();

    address.deleteAllAddress();

    var newAddresses= hbm.getContactList();
    var expectedList = new ArrayList<>(oldAddress);
    expectedList.clear();

    assertFalse(address.acceptAlertIfPresent(), "Allert не показывается, если была хотя бы одна запись");
    assertTrue(address.getAddressCount() == 0, "Все контакты должны быть удалены");
    assertTrue(hbm.getContactList().isEmpty(), "Все контакты должны быть удалены");

    Assertions.assertEquals(newAddresses, expectedList);

  }

  @Test
  public void alertAppearsOnEmptyDeletionTest() {
    AddressHelper address = app.address();
    HibernateHelper hbm = app.hbm();

    var initialSize = hbm.getContactsCount();
    if (hbm.getContactsCount()!=0) {
      address.deleteAllAddress();}

    address.deleteAllAddress();
    assertTrue(address.acceptAlertIfPresent(), "Должен появиться alert при попытке удалить без выбора");

    var finalSize = hbm.getContactsCount();
    assertTrue(initialSize >= finalSize, "Количество контактов не должно увеличиться");
  }

}
