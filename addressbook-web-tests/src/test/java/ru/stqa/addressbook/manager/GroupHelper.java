package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.models.GroupData;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

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

    private void deleteGroup() {
        buttonClick(By.xpath("(//input[@name='delete'])[2]"));
        buttonClick(By.linkText("groups"));
    }
    private void editGroup() {
        buttonClick(By.xpath("(//input[@name='edit'])"));
    }
    private void selectCheckbox(GroupData group){
        openGroupPage();
        buttonClick(By.cssSelector(String.format(("input[value ='%s']"), group.id())));
    }

    public void deleteElement(GroupData group) {
        selectCheckbox(group);
        deleteGroup();
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

    public void modifyGroup(GroupData group, GroupData modifiedGroup) {
        openGroupPage();
        selectCheckbox(group);
        editGroup();
        type(By.name("group_name"), modifiedGroup.name());
        type(By.name("group_header"), modifiedGroup.header());
        type(By.name("group_footer"), modifiedGroup.footer());
        buttonClick(By.name("update"));
        openGroupPage();
    }

    public void deleteAllGroup() {
        openGroupPage();
        selectAllGroups();
        deleteGroup();
    }
    private void selectAllGroups() {
        var checkboxes = driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
    }
    }

    public List<GroupData> getListGroups() {
        openGroupPage();
        var groups = new ArrayList<GroupData>();
        var spans = manager.driver.findElements(By.cssSelector("span.group"));
        for (var span:spans) {
            var name = span.getText();
            var checkbox = span.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }
}
