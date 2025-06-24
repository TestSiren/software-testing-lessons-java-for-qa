package ru.stqa.addressbook.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.manager.AddressHelper;
import ru.stqa.addressbook.models.AddressData;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateAddressBook extends TestBase {

  @ParameterizedTest
  @MethodSource("ru.stqa.addressbook.dataproviders.AddressProvider#addressProvider")
  public void createAddressBook(AddressData address) {
    AddressHelper addresses = app.address();

    int initialSize = addresses.getAddressCount();

    addresses.createAddress(address);

    int finalSize = addresses.getAddressCount();

    assertTrue(initialSize < finalSize);
  }
  @ParameterizedTest
  @MethodSource("ru.stqa.addressbook.dataproviders.AddressProvider#negativeAddressProvider")
  public void cannotCreateInvalidAddress(AddressData address) {
    AddressHelper addresses = app.address();

    int initialSize = addresses.getAddressCount();

    addresses.createAddress(address);

    int finalSize = addresses.getAddressCount();

    assertTrue(initialSize == finalSize);
  }
}
