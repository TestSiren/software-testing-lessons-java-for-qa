package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddressHelper extends HelperBase {

    public AddressHelper(ApplicationManager manager) {
        super(manager);
    }

    public void CreationAddress() {
        buttonClick(By.linkText("add new"));

        type(By.name("firstname"), "firstname");
        type(By.name("middlename"), "Middle Name");
        type(By.name("lastname"), "Last Name");
        type(By.name("nickname"), "Nickname");
        type(By.name("title"), "Title");
        type(By.name("company"), "Company");
        type(By.name("address"), "Address");
        type(By.name("home"), "Home");
        type(By.name("mobile"), "Mobile");
        type(By.name("work"), "Work");
        type(By.name("fax"), "Fax");
        type(By.name("email"), "E-mail");
        type(By.name("email2"), "E-mail2");
        type(By.name("email3"), "E-mail3");
        type(By.name("homepage"), "Homepage");

        select(By.name("bday"), "1");
        select(By.name("bmonth"), "January");
        type(By.name("byear"), "1990");

        select(By.name("aday"), "1");
        select(By.name("amonth"), "January");
        type(By.name("ayear"), "2000");

        select(By.name("new_group"), "some name");

        buttonClick(By.name("submit"));
        buttonClick(By.linkText("home page"));
    }


    public int CheckCreationAddress() {
        openAddressPage();
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        int count = rows.size() > 1 ? rows.size() - 1 : 0; //первый tr это заголовки столбцов
        if (count > 0) {
            System.out.println("Найдены строки в таблице: " + rows.size());
        } else {
            System.out.println("Таблица пуста.");
        }
        return count;
    }

    private void openAddressPage() {
        buttonClick(By.linkText("home"));
    }

    public void DeletedAddress() {
        openAddressPage();
            WebElement firstCheckbox = driver.findElement(By.cssSelector("input[name='selected[]']"));
        firstCheckbox.click();
        buttonClick(By.xpath("//input[@value='Delete']"));
        //driver.switchTo().alert().accept();
    }

    public void DeletedAllAddress() {
        openAddressPage();
        buttonClick(By.id("MassCB"));
        buttonClick(By.xpath("//input[@value='Delete']"));
       // driver.switchTo().alert().accept();
    }
}