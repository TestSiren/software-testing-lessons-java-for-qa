package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.addressbook.steps.CRUDlsForGroup;

public class TestBase {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1721, 1033));
        auth();
    }

    @AfterEach
    public void tearDown() {
        logout();
        driver.quit();
    }

    public void auth() {
        driver.get("http://localhost/addressbook/");
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }
    public void openPage(String page) {
        driver.findElement(By.linkText(page)).click();
    }

}
