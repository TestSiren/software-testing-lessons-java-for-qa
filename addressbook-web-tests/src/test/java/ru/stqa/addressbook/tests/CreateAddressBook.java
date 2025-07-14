package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.manager.AddressHelper;
import static ru.stqa.addressbook.manager.AddressHelper.equalsByNamesAndId;
import ru.stqa.addressbook.models.AddressData;
import ru.stqa.addressbook.models.GroupData;
import ru.stqa.addressbook.common.CommonFunctions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.stqa.addressbook.comporators.AddressComparators.byId;


public class CreateAddressBook extends TestBase {
/*
  @ParameterizedTest
  @MethodSource("ru.stqa.addressbook.dataproviders.AddressProvider#addressProvider")
  public void createAddressBook(AddressData address) {
    AddressHelper addresses = app.address();

    var oldAddress = addresses.getListAddress();
    oldAddress.sort(byId);
    addresses.createAddress(address);

    var newAddresses = addresses.getListAddress();
    newAddresses.sort(byId);

    var expectedList = new ArrayList<>(oldAddress);
    expectedList.add(address.withId(newAddresses.get(newAddresses.size() - 1).id()).withFirstname(address.firstname())
            .withLastname(address.lastname()));


    expectedList.sort(byId);
    assertTrue(equalsByNamesAndId(newAddresses, expectedList));

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
*/
@Test
  public void createAddressBookWithGroup() {
  var address = new AddressData()
          .withFirstname(CommonFunctions.randomString(5))
          .withLastname(CommonFunctions.randomString(5))
          .withEmail(List.of(CommonFunctions.randomString(5) + "@example.com"))
          .withBday(CommonFunctions.randomDay())
          .withBmonth(CommonFunctions.randomMonths())
          .withByear(CommonFunctions.randomYear())
          .withAday(CommonFunctions.randomDay())
          .withAmonth(CommonFunctions.randomMonths())
          .withAyear(CommonFunctions.randomYear())
          .withMobile("99999999999")
          .withAddress("Test address");
    var addresses = app.address();
    var hbm = app.hbm();

    if (hbm.getGroupsCount() == 0) {
      hbm.createGroup(new GroupData().withName("some name"));
    }
    var group = hbm.getGroupList().get(0);
    var oldRelated = hbm.getContactsInGroup(group);
    addresses.createAddressInGroup(address, group);
    var newRelated = hbm.getContactsInGroup(group);
    Assertions.assertEquals(oldRelated.size()+1, newRelated.size()); // сделать более сложную проверку.


  }

}