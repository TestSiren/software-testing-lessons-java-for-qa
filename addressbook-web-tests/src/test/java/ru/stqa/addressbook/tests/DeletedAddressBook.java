package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.manager.AddressHelper;
import ru.stqa.addressbook.models.AddressData;
import ru.stqa.addressbook.models.GroupData;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeletedAddressBook extends TestBase {

  @Test
  public void deleteAddressBook() {
    AddressHelper actions = app.address();

    int startedAddress = actions.CheckCreationAddress();

    if (startedAddress==0){actions.CreationAddress(); startedAddress++;}
    actions.DeletedAddress();

    int afterAddress = actions.CheckCreationAddress();
    assertTrue(startedAddress > afterAddress);
  }
}
