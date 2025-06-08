package ru.stqa.addressbook.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.models.GroupData;

import java.util.List;

public class CRUDlsForGroup {
    private WebDriver driver;

    public CRUDlsForGroup(WebDriver driver) {
        this.driver = driver;
    }
    public void CreationGroup(GroupData groupsData) {
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys(groupsData.name());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys(groupsData.header());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys(groupsData.footer());
        driver.findElement(By.name("submit")).click();
    }

    public void GoToLink() {
        driver.findElement(By.linkText("group page")).click();
    }

    public void DeletedGroup() {
            driver.findElement(By.name("selected[]")).click();
            driver.findElement(By.xpath("(//input[@name=\'delete\'])[2]")).click();
            driver.findElement(By.linkText("group page")).click();
    }

    public int CheckCreationGroups() {
        List<WebElement> groups = driver.findElements(By.cssSelector("span.group"));
        if (!groups.isEmpty()) {
            System.out.println("Группы найдены: " + groups.size());
        } else {
            System.out.println("Групп нет. Отображается только hr/bp.");
        }
        return groups.size();
    }
}
