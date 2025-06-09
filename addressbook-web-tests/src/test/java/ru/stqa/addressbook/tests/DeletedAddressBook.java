package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.manager.AddressHelper;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeletedAddressBook extends TestBase {

  @Test
  public void deleteSingleAddressTest() {
    AddressHelper address = app.address();

    int startedAddress = address.CheckCreationAddress();
    if (startedAddress == 0) {
      address.CreationAddress();
      startedAddress++;
    }

    address.DeletedAddress();
    assertFalse(address.acceptAlertIfPresent(), "Allert не показывается, если была хотя бы одна запись");

    int afterAddress = address.CheckCreationAddress();
    assertTrue(startedAddress > afterAddress, "Контакт должен быть удалён");
  }

  @Test
  public void deleteAllAddressesTest() {
    AddressHelper address = app.address();

    int startedAddress = address.CheckCreationAddress();
    if (startedAddress == 0) {
      address.CreationAddress();}

    address.DeletedAllAddress();
    assertFalse(address.acceptAlertIfPresent(), "Allert не показывается, если была хотя бы одна запись");

    int afterAddress = address.CheckCreationAddress();
    assertTrue(afterAddress == 0, "Все контакты должны быть удалены");
  }

  @Test
  public void deleteAllAddressesWithoutCreationTest() {
    AddressHelper address = app.address();

    int startedAddress = address.CheckCreationAddress();
    if (startedAddress != 0) {
      address.DeletedAllAddress();}

    address.DeletedAllAddress();
    assertTrue(address.acceptAlertIfPresent(), "Должен появиться alert при попытке удалить без выбора");

    int afterAddress = address.CheckCreationAddress();
    assertTrue(startedAddress >= afterAddress, "Количество контактов не должно увеличиться");
  }
}
