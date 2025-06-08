package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.manager.GroupHelper;

import java.util.*;

public class CreateAddressBook extends TestBase{

  @Test
  public void createAddressBook() {
    GroupHelper actions = app.groups();
    actions.findElement(By.linkText("add new")).click();
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).sendKeys("First Name");
    driver.findElement(By.name("middlename")).click();
    driver.findElement(By.name("middlename")).sendKeys("Middle Name");
    driver.findElement(By.name("theform")).click();
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).sendKeys("Last Name");
    driver.findElement(By.name("nickname")).click();
    driver.findElement(By.name("nickname")).sendKeys("Nickname");
    driver.findElement(By.name("title")).click();
    driver.findElement(By.name("title")).sendKeys("Title");
    driver.findElement(By.name("company")).click();
    driver.findElement(By.name("company")).sendKeys("Company");
    driver.findElement(By.name("address")).click();
    driver.findElement(By.name("address")).sendKeys("Address");
    driver.findElement(By.name("home")).click();
    driver.findElement(By.name("home")).sendKeys("Home");
    driver.findElement(By.name("mobile")).click();
    driver.findElement(By.name("mobile")).sendKeys("Mobile");
    driver.findElement(By.name("work")).click();
    driver.findElement(By.name("work")).sendKeys("Work");
    driver.findElement(By.name("fax")).click();
    driver.findElement(By.name("fax")).sendKeys("Fax");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).sendKeys("E-mail");
    driver.findElement(By.name("email2")).click();
    driver.findElement(By.name("email2")).sendKeys("E-mail2");
    driver.findElement(By.name("theform")).click();
    driver.findElement(By.name("email3")).click();
    driver.findElement(By.name("email3")).sendKeys("E-mail3");
    driver.findElement(By.name("homepage")).click();
    driver.findElement(By.name("homepage")).sendKeys("Homepage");
    driver.findElement(By.name("bday")).click();
    {
      WebElement dropdown = driver.findElement(By.name("bday"));
      dropdown.findElement(By.xpath("//option[. = '1']")).click();
    }
    driver.findElement(By.xpath("//div[@id=\'content\']/form/select/option[3]")).click();
    driver.findElement(By.name("bmonth")).click();
    {
      WebElement dropdown = driver.findElement(By.name("bmonth"));
      dropdown.findElement(By.xpath("//option[. = 'January']")).click();
    }
    driver.findElement(By.xpath("//div[@id=\'content\']/form/select[2]/option[2]")).click();
    driver.findElement(By.name("byear")).click();
    driver.findElement(By.name("byear")).sendKeys("1990");
    driver.findElement(By.name("aday")).click();
    {
      WebElement dropdown = driver.findElement(By.name("aday"));
      dropdown.findElement(By.xpath("//option[. = '1']")).click();
    }
    driver.findElement(By.xpath("//div[@id=\'content\']/form/select[3]/option[3]")).click();
    driver.findElement(By.name("amonth")).click();
    {
      WebElement dropdown = driver.findElement(By.name("amonth"));
      dropdown.findElement(By.xpath("//option[. = 'January']")).click();
    }
    driver.findElement(By.xpath("//div[@id=\'content\']/form/select[4]/option[2]")).click();
    driver.findElement(By.name("ayear")).click();
    driver.findElement(By.name("ayear")).sendKeys("2000");
    driver.findElement(By.name("new_group")).click();
    {
      WebElement dropdown = driver.findElement(By.name("new_group"));
      dropdown.findElement(By.xpath("//option[. = 'some name']")).click();
    }
    driver.findElement(By.xpath("//option[contains(.,\'some name\')]")).click();
    driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
    driver.findElement(By.linkText("home page")).click();
  }
}
