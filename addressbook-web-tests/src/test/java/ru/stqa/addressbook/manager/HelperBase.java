package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.Paths;

public class HelperBase {
    protected final ApplicationManager manager;
    protected WebDriver driver;


    public HelperBase(ApplicationManager manager){
        this.manager = manager;
        this.driver = manager.driver;
    }

    public void buttonClick(By locator){
        manager.driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        if (text != null && !text.equals(element.getAttribute("value"))) {
            element.sendKeys(text);
        }
    }

    protected void attach(By locator, String file) {
        WebElement element = driver.findElement(locator);
        if (file != null && !file.equals(element.getAttribute("value"))) {
            element.sendKeys(Paths.get(file).toAbsolutePath().toString());
        }
    }

    protected void select(By locator, String value) {
        WebElement element = driver.findElement(locator);
        element.click();
        element.findElement(By.xpath(String.format(".//option[. = '%s']", value))).click();
    }

    protected boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
}
