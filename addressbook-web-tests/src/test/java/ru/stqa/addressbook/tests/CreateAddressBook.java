package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.manager.AddressHelper;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateAddressBook extends TestBase {

  @Test
  public void createAddressBook() {
    AddressHelper actions = app.address();

    int startedAddress = actions.CheckCreationAddress();

    actions.CreationAddress();

    int afterAddress = actions.CheckCreationAddress();

    assertTrue(startedAddress < afterAddress);
  }
}
