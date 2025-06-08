package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.models.GroupData;

import java.util.List;

public class GroupHelper {
    private final ApplicationManager manager;

    public GroupHelper (ApplicationManager manager){
        this.manager = manager;
    }
    public void CreationGroup(GroupData groupsData) {
        openGroupPage();
        manager.driver.findElement(By.name("new")).click();
        manager.driver.findElement(By.name("group_name")).click();
        manager.driver.findElement(By.name("group_name")).sendKeys(groupsData.name());
        manager.driver.findElement(By.name("group_header")).click();
        manager.driver.findElement(By.name("group_header")).sendKeys(groupsData.header());
        manager.driver.findElement(By.name("group_footer")).click();
        manager.driver.findElement(By.name("group_footer")).sendKeys(groupsData.footer());
        manager.driver.findElement(By.name("submit")).click();
    }

    private void openGroupPage() {
        manager.driver.findElement(By.linkText("groups")).click();
    }

    public void DeletedGroup() {
        openGroupPage();
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.xpath("(//input[@name=\'delete\'])[2]")).click();
        manager.driver.findElement(By.linkText("group page")).click();
    }

    public int CheckCreationGroups() {
        openGroupPage();
        List<WebElement> groups = manager.driver.findElements(By.cssSelector("span.group"));
        if (!groups.isEmpty()) {
            System.out.println("Группы найдены: " + groups.size());
        } else {
            System.out.println("Групп нет. Отображается только hr/bp.");
        }
        return groups.size();
    }
}