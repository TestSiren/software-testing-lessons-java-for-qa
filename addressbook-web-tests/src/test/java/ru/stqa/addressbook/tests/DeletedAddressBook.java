package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.manager.AddressHelper;
import ru.stqa.addressbook.models.AddressData;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeletedAddressBook extends TestBase {
  @Test
  public void deleteSingleAddressTest() {
    AddressHelper address = app.address();

    if (address.getAddressCount() == 0) {
      address.createAddress(new AddressData());
    }

    var oldAddress= app.address().getListAddress();
    var rnd = new Random();
    var index = rnd.nextInt(oldAddress.size());

    address.deleteAddress(oldAddress.get(index));
    var newAddress= app.address().getListAddress();

    var expectedList = new ArrayList<>(oldAddress);
    expectedList.remove(index);

    assertFalse(address.acceptAlertIfPresent(), "Allert не показывается, если была хотя бы одна запись");
    Assertions.assertEquals(newAddress, expectedList);

  }

  @Test
  public void deleteAllAddressesTest() {
    AddressHelper address = app.address();

    if (address.getAddressCount() == 0) {
      address.createAddress(new AddressData());}
    var oldAddress= app.address().getListAddress();

    address.deleteAllAddress();
    var newAddress= app.address().getListAddress();
    var expectedList = new ArrayList<>(oldAddress);
    expectedList.clear();

    assertFalse(address.acceptAlertIfPresent(), "Allert не показывается, если была хотя бы одна запись");
    assertTrue(address.getAddressCount() == 0, "Все контакты должны быть удалены");
    Assertions.assertEquals(newAddress, expectedList);

  }

  @Test
  public void alertAppearsOnEmptyDeletionTest() {
    AddressHelper address = app.address();

    int initialSize = address.getAddressCount();
    if (address.getAddressCount() != 0) {
      address.deleteAllAddress();}

    address.deleteAllAddress();
    assertTrue(address.acceptAlertIfPresent(), "Должен появиться alert при попытке удалить без выбора");

    int finalSize = address.getAddressCount();
    assertTrue(initialSize >= finalSize, "Количество контактов не должно увеличиться");
  }

}
