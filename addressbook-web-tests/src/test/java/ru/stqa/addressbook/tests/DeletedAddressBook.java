package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.manager.AddressHelper;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeletedAddressBook extends TestBase {

  @Test
  public void deleteSingleAddressTest() {
    AddressHelper actions = app.address();

    int startedAddress = actions.CheckCreationAddress();
    if (startedAddress == 0) {
      actions.CreationAddress();
      startedAddress++;
    }

    actions.DeletedAddress();
    assertFalse(actions.acceptAlertIfPresent(), "Allert не показывается, если была хотя бы одна запись");

    int afterAddress = actions.CheckCreationAddress();
    assertTrue(startedAddress > afterAddress, "Контакт должен быть удалён");
  }

  @Test
  public void deleteAllAddressesTest() {
    AddressHelper actions = app.address();

    int startedAddress = actions.CheckCreationAddress();
    if (startedAddress == 0) {
      actions.CreationAddress();}

    actions.DeletedAllAddress();
    assertFalse(actions.acceptAlertIfPresent(), "Allert не показывается, если была хотя бы одна запись");

    int afterAddress = actions.CheckCreationAddress();
    assertTrue(afterAddress == 0, "Все контакты должны быть удалены");
  }

  @Test
  public void deleteAllAddressesWithoutCreationTest() {
    AddressHelper actions = app.address();

    int startedAddress = actions.CheckCreationAddress();
    if (startedAddress != 0) {
      actions.DeletedAllAddress();}

    actions.DeletedAllAddress();
    assertTrue(actions.acceptAlertIfPresent(), "Должен появиться alert при попытке удалить без выбора");

    int afterAddress = actions.CheckCreationAddress();
    assertTrue(startedAddress >= afterAddress, "Количество контактов не должно увеличиться");
  }
}
