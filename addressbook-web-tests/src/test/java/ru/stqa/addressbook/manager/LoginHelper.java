package ru.stqa.addressbook.manager;

import org.openqa.selenium.By;
import java.util.Properties;

public class LoginHelper extends HelperBase {

    private Properties properties;
    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void auth(Properties properties) {
        this.properties = properties;
        driver.get(properties.getProperty("web.baseUrl"));
        type(By.name("user"), properties.getProperty("web.username"));
        type(By.name("pass"), properties.getProperty("web.password"));
        buttonClick(By.xpath("//input[@value='Login']"));
    }

    public void logout() {
        buttonClick(By.linkText("Logout"));
    }
}

