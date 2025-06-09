package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.models.GroupData;

import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createGroup(GroupData groupsData) {
        openGroupPage();
        buttonClick(By.name("new"));
        type(By.name("group_name"), groupsData.name());
        type(By.name("group_header"), groupsData.header());
        type(By.name("group_footer"), groupsData.footer());
        buttonClick(By.name("submit"));
    }

    private void openGroupPage() {
        buttonClick(By.linkText("groups"));
    }

    public void deletedGroup() {
        openGroupPage();
        buttonClick(By.name("selected[]"));
        buttonClick(By.xpath("(//input[@name='delete'])[2]"));
        buttonClick(By.linkText("groups"));
    }

    public int getGroupsCount() {
        openGroupPage();
        List<WebElement> groups = driver.findElements(By.cssSelector("span.group"));
        if (!groups.isEmpty()) {
            System.out.println("Группы найдены: " + groups.size());
        } else {
            System.out.println("Групп нет. Отображается только hr/bp.");
        }
        return groups.size();
    }
}
