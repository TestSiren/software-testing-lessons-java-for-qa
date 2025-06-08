package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import ru.stqa.addressbook.models.AddressData;

public class AddressHelper extends HelperBase {

    public AddressHelper(ApplicationManager manager) {
        super(manager);
    }

    public void CreationAddress(AddressData addressData) {
        buttonClick(By.linkText("add new"));

        type(By.name("firstname"), addressData.firstname());
        type(By.name("middlename"), "Middle Name");
        type(By.name("lastname"), "Last Name");
        type(By.name("nickname"), "Nickname");
        type(By.name("title"), "Title");
        type(By.name("company"), "Company");
        type(By.name("address"), "Address");
        type(By.name("home"), "Home");
        type(By.name("mobile"), "Mobile");
        type(By.name("work"), "Work");
        type(By.name("fax"), "Fax");
        type(By.name("email"), "E-mail");
        type(By.name("email2"), "E-mail2");
        type(By.name("email3"), "E-mail3");
        type(By.name("homepage"), "Homepage");

        select(By.name("bday"), "1");
        select(By.name("bmonth"), "January");
        type(By.name("byear"), "1990");

        select(By.name("aday"), "1");
        select(By.name("amonth"), "January");
        type(By.name("ayear"), "2000");

        select(By.name("new_group"), "some name");

        buttonClick(By.name("submit"));
        buttonClick(By.linkText("home page"));
    }


}