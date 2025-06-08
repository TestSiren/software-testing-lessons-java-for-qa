package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void auth(String login, String password) {
        driver.get("http://localhost/addressbook/");
        type(By.name("user"), login);
        type(By.name("pass"), password);
        buttonClick(By.xpath("//input[@value='Login']"));
    }

    public void logout() {
        buttonClick(By.linkText("Logout"));
    }
}

