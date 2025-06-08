package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.models.GroupData;

import java.util.List;

public class GroupHelper {
    private final ApplicationManager manager;

    public GroupHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void CreationGroup(GroupData groupsData) {
        openGroupPage();
        manager.helper().buttonClick(By.name("new"));
        manager.helper().type(By.name("group_name"), groupsData.name());
        manager.helper().type(By.name("group_header"), groupsData.header());
        manager.helper().type(By.name("group_footer"), groupsData.footer());
        manager.helper().buttonClick(By.name("submit"));
    }

    private void openGroupPage() {
        manager.helper().buttonClick(By.linkText("groups"));
    }

    public void DeletedGroup() {
        openGroupPage();
        manager.helper().buttonClick(By.name("selected[]"));
        manager.helper().buttonClick(By.xpath("(//input[@name='delete'])[2]"));
        manager.helper().buttonClick(By.linkText("groups"));
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
