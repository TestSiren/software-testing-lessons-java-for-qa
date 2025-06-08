package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import ru.stqa.addressbook.models.AddressData;

public class AddressHelper extends HelperBase {

    public AddressHelper(ApplicationManager manager) {
        super(manager);
    }

    public void CreationAddress(AddressData addressData) {
        openGroupPage();
        buttonClick(By.name("new"));
        type(By.name("group_name"), groupsData.name());
        type(By.name("group_header"), groupsData.header());
        type(By.name("group_footer"), groupsData.footer());
        buttonClick(By.name("submit"));
    }


}