package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.manager.AddressHelper;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateAddressBook extends TestBase {

  //@Test
  @RepeatedTest(5)  // сгенерировать данные в колве (n)
  public void createAddressBook() {
    AddressHelper actions = app.address();

    int startedAddress = actions.CheckCreationAddress();

    actions.CreationAddress();

    int afterAddress = actions.CheckCreationAddress();

    assertTrue(startedAddress < afterAddress);
  }
}
