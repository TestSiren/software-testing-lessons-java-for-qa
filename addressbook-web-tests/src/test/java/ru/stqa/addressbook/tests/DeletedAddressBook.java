package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.manager.AddressHelper;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeletedAddressBook extends TestBase {

  @Test
  public void deleteSingleAddressTest() {
    AddressHelper address = app.address();

    int initialSize = address.getAddressCount();
   /* if (initialSize == 0) {
      address.createAddress();
      initialSize++;
    }
*/
    address.deleteAddress();
    assertFalse(address.acceptAlertIfPresent(), "Allert не показывается, если была хотя бы одна запись");

    int finalSize = address.getAddressCount();
    assertTrue(initialSize > finalSize, "Контакт должен быть удалён");
  }

  @Test
  public void deleteAllAddressesTest() {
    AddressHelper address = app.address();

    int initialSize = address.getAddressCount();
  /*  if (initialSize == 0) {
      address.createAddress();}
*/
    address.deleteAllAddress();
    assertFalse(address.acceptAlertIfPresent(), "Allert не показывается, если была хотя бы одна запись");

    int finalSize = address.getAddressCount();
    assertTrue(finalSize == 0, "Все контакты должны быть удалены");
  }

  @Test
  public void deleteAllAddressesWithoutCreationTest() {
    AddressHelper address = app.address();

    int initialSize = address.getAddressCount();
    if (initialSize != 0) {
      address.deleteAllAddress();}

    address.deleteAllAddress();
    assertTrue(address.acceptAlertIfPresent(), "Должен появиться alert при попытке удалить без выбора");

    int finalSize = address.getAddressCount();
    assertTrue(initialSize >= finalSize, "Количество контактов не должно увеличиться");
  }
}
