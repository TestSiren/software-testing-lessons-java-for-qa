package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.manager.AddressHelper;
import ru.stqa.addressbook.models.AddressData;
import ru.stqa.addressbook.models.GroupData;
import ru.stqa.addressbook.manager.HibernateHelper;
import ru.stqa.addressbook.common.CommonFunctions;

import java.util.ArrayList;
import java.util.List;

import static ru.stqa.addressbook.comporators.AddressComparators.byId;


public class CreateAddressBook extends TestBase {
  @ParameterizedTest
  @MethodSource("ru.stqa.addressbook.dataproviders.AddressProvider#addressProvider")
  public void createAddressBook(AddressData address) {
    AddressHelper addresses = app.address();
    HibernateHelper hbm = app.hbm();

    var oldAddress = hbm.getContactList();
    oldAddress.sort(byId);
    addresses.createAddress(address);

    var newAddresses = hbm.getContactList();
    newAddresses.sort(byId);

    var maxId = newAddresses.get(newAddresses.size() - 1).id();
    var expectedList = new ArrayList<>(oldAddress);
    expectedList.add(new AddressData()
            .withId(maxId)
            .withFirstname(address.firstname())
            .withMiddlename(address.middlename())
            .withLastname(address.lastname())
            .withNickname(address.nickname())
            .withTitle(address.title())
            .withCompany(address.company())
            .withAddress(address.address())
            .withHome(address.home())
            .withMobile(address.mobile())
            .withWork(address.work())
            .withFax(address.fax())
            .withHomepage(address.homepage())
            .withBday(address.bday())
            .withBmonth(address.bmonth())
            .withByear(address.byear())
            .withAday(address.aday())
            .withAmonth(address.amonth())
            .withAyear(address.ayear())
            .withGroup(address.group())
    );
    expectedList.sort(byId);
    Assertions.assertEquals(newAddresses, expectedList);
  }
  @ParameterizedTest
  @MethodSource("ru.stqa.addressbook.dataproviders.AddressProvider#negativeAddressProvider")
  public void cannotCreateInvalidAddress(AddressData address) {
    AddressHelper addresses = app.address();
    HibernateHelper hbm = app.hbm();

    var oldAddress = hbm.getContactList();

    addresses.createAddress(address);

    var newAddresses = hbm.getContactList();

    Assertions.assertEquals(newAddresses, oldAddress);
  }

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