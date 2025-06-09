package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.manager.AddressHelper;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateAddressBook extends TestBase {

  @Test
  //@RepeatedTest(5)  // сгенерировать данные в колве (n) для тестирования удаления
  public void createAddressBook() {
    AddressHelper address = app.address();

    int initialSize = address.getCreationAddress();

    address.createAddress();

    int finalSize = address.getCreationAddress();

    assertTrue(initialSize < finalSize);
  }
}
