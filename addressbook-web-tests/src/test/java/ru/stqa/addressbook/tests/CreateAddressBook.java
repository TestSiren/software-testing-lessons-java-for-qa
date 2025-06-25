package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.manager.AddressHelper;
import ru.stqa.addressbook.models.AddressData;

import java.util.ArrayList;
import static ru.stqa.addressbook.comporators.AddressComparators.byFirstAndLastName;


public class CreateAddressBook extends TestBase {

  @ParameterizedTest
  @MethodSource("ru.stqa.addressbook.dataproviders.AddressProvider#addressProvider")
  public void createAddressBook(AddressData address) {
    AddressHelper addresses = app.address();

    var oldAddress = addresses.getListAddress();
    oldAddress.sort(byFirstAndLastName);
    addresses.createAddress(address);

    var newAddresses = addresses.getListAddress();
    newAddresses.sort(byFirstAndLastName);

    var expectedList = new ArrayList<>(oldAddress);
    expectedList.add(address.withId(newAddresses.get(newAddresses.size() - 1).id()).withFirstname(address.firstname())
            .withLastname(address.lastname()));


    expectedList.sort(byFirstAndLastName);
    System.out.println(newAddresses);
    System.out.println(expectedList);

    for (int i = 0; i < expectedList.size(); i++) {
      Assertions.assertEquals(expectedList.get(i).firstname(), newAddresses.get(i).firstname());
      Assertions.assertEquals(expectedList.get(i).lastname(), newAddresses.get(i).lastname());
    }


  }
  @ParameterizedTest
  @MethodSource("ru.stqa.addressbook.dataproviders.AddressProvider#negativeAddressProvider")
  public void cannotCreateInvalidAddress(AddressData address) {
    AddressHelper addresses = app.address();

    var oldAddress = addresses.getListAddress();

    addresses.createAddress(address);

    var newAddresses = addresses.getListAddress();

    Assertions.assertEquals(newAddresses, oldAddress);
  }
}
