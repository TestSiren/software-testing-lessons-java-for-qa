package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;

import java.util.ArrayList;
import java.util.List;
import ru.stqa.addressbook.models.AddressData;
import ru.stqa.addressbook.models.GroupData;

public class AddressHelper extends HelperBase {

    public AddressHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createAddress(AddressData addressData) {
        buttonClick(By.linkText("add new"));

        type(By.name("firstname"), addressData.firstname());
        type(By.name("middlename"), addressData.middlename());
        type(By.name("lastname"), addressData.lastname());
        type(By.name("nickname"), addressData.nickname());
        type(By.name("title"), addressData.title());
        type(By.name("company"), addressData.company());
        type(By.name("address"), addressData.address());
        type(By.name("home"), addressData.home());
        type(By.name("mobile"), addressData.mobile());
        type(By.name("work"), addressData.work());
        type(By.name("fax"), addressData.fax());
        type(By.name("email"), addressData.email());
        type(By.name("email2"), addressData.email2());
        type(By.name("email3"), addressData.email3());
        type(By.name("homepage"), addressData.homepage());

        select(By.name("bday"), String.valueOf(addressData.bday()));
        select(By.name("bmonth"), addressData.bmonth());
        type(By.name("byear"), addressData.byear());

        select(By.name("aday"), String.valueOf(addressData.aday()));
        select(By.name("amonth"), addressData.amonth());
        type(By.name("ayear"), addressData.ayear());

        select(By.name("new_group"), addressData.group());

        buttonClick(By.name("submit"));
        buttonClick(By.linkText("home page"));
    }
    private void selectCheckbox(AddressData address){
        openAddressPage();
        buttonClick(By.cssSelector(String.format(("input[value ='%s']"), address.id())));
    }

    public int getAddressCount() {
        openAddressPage();
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        int count = rows.size() > 1 ? rows.size() - 1 : 0; // исключаем заголовок
        return count;
    }

    private void openAddressPage() {
        buttonClick(By.linkText("home"));
    }

    public void deleteAddress(AddressData address) {
        selectCheckbox(address);
        buttonClick(By.xpath("//input[@value='Delete']"));
    }

    public void deleteAllAddress() {
        openAddressPage();
        buttonClick(By.id("MassCB"));
        buttonClick(By.xpath("//input[@value='Delete']"));
    }

    public boolean acceptAlertIfPresent() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public List<AddressData> getListAddress() {
        openAddressPage();
        var addressList = new ArrayList<AddressData>();
        var rows = manager.driver.findElements(By.cssSelector("tr[name='entry']"));
        for (var row : rows) {
            var cells = row.findElements(By.tagName("td"));

            String id = cells.get(0).findElement(By.name("selected[]")).getAttribute("value");
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String address = cells.get(3).getText();

            var emailElements = cells.get(4).findElements(By.tagName("a"));
            String email = emailElements.size() > 0 ? emailElements.get(0).getText() : null;
            String email2 = emailElements.size() > 1 ? emailElements.get(1).getText() : null;
            String email3 = emailElements.size() > 2 ? emailElements.get(2).getText() : null;

            addressList.add(new AddressData()
                    .withId(id)
                    .withFirstname(firstname)
                    .withLastname(lastname)
                    .withAddress(address)
                    .withEmail(email)
                    .withEmail2(email2)
                    .withEmail3(email3));
        }
        return addressList;
    }
}