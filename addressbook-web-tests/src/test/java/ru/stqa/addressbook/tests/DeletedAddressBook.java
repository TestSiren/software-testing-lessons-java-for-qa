package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.manager.AddressHelper;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeletedAddressBook extends TestBase {

  @Test
  public void deleteSingleAddressTest() {
    AddressHelper actions = app.address();

    int startedAddress = actions.CheckCreationAddress();

    if (startedAddress==0){actions.CreationAddress(); startedAddress++;}
    actions.DeletedAddress();

    int afterAddress = actions.CheckCreationAddress();
    assertTrue(startedAddress > afterAddress);
  }

  @Test
  public void deleteAllAddressesTest() {
    AddressHelper actions = app.address();

    int startedAddress = actions.CheckCreationAddress();

    if (startedAddress==0){actions.CreationAddress(); startedAddress++;}
    actions.DeletedAllAddress(startedAddress);

    int afterAddress = actions.CheckCreationAddress();
    assertTrue(startedAddress > afterAddress);
  }

  @Test
  public void deleteAllAddressesWithoutCreationTest() {
    AddressHelper actions = app.address();

    int startedAddress = actions.CheckCreationAddress();

    actions.DeletedAllAddress(startedAddress); //в данном тесте не создаем запись, чтобы проверить наличие алерта

    int afterAddress = actions.CheckCreationAddress();

    assertTrue(startedAddress >= afterAddress);

  }
}
