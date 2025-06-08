package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;

public class LoginHelper {
    private final ApplicationManager manager;

    public LoginHelper (ApplicationManager manager){
        this.manager = manager;
    }
    public void auth(String login, String password) {
        manager.driver.get("http://localhost/addressbook/");
        manager.helper().type(By.name("user"), login);
        manager.helper().type(By.name("pass"), password);
        manager.helper().buttonClick(By.xpath("//input[@value='Login']"));
    }

    public void logout() {
        manager.helper().buttonClick(By.linkText("Logout"));
    }
}
