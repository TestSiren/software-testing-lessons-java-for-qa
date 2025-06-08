package ru.stqa.addressbook.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CRUDlsForGroup {
    private WebDriver driver;

    public CRUDlsForGroup(WebDriver driver) {
        this.driver = driver;
    }
    public void CreationGroup() {
        driver.findElement(By.linkText("groups")).click();
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys("group name");
        driver.findElement(By.name("group_header")).sendKeys("group header");
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys("group footer");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
        driver.findElement(By.cssSelector(".group")).click();
        driver.findElement(By.cssSelector("html")).click();
    }
    public void DeletedGroup() {
            driver.findElement(By.name("selected[]")).click();
            driver.findElement(By.xpath("(//input[@name=\'delete\'])[2]")).click();
            driver.findElement(By.linkText("group page")).click();
    }

    public int CheckCreationGroups() {
        driver.get("http://localhost/addressbook/group.php");
        List<WebElement> groups = driver.findElements(By.cssSelector("span.group"));
        if (!groups.isEmpty()) {
            System.out.println("Группы найдены: " + groups.size());
        } else {
            System.out.println("Групп нет. Отображается только hr/bp.");
        }
        return groups.size();
    }
}
