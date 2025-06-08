package ru.stqa.addressbook.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class LogInAndOut {
    private WebDriver driver;

    public LogInAndOut(WebDriver driver) {
        this.driver = driver;
    }
    public void auth() {
        driver.get("http://localhost/addressbook/");
        driver.manage().window().setSize(new Dimension(1721, 1033));
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }
    public void logout(){
        driver.findElement(By.linkText("Logout")).click();
    }
}
