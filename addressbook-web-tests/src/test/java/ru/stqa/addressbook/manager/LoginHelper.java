package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;

public class LoginHelper {
    private final ApplicationManager manager;

    public LoginHelper (ApplicationManager manager){
        this.manager = manager;
    }
    public void auth(String login, String password) {
        manager.driver.get("http://localhost/addressbook/");
        manager.driver.findElement(By.name("user")).click();
        manager.driver.findElement(By.name("user")).sendKeys(login);
        manager.driver.findElement(By.name("pass")).sendKeys(password);
        manager.driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void logout() {
        manager.driver.findElement(By.linkText("Logout")).click();
    }
}
