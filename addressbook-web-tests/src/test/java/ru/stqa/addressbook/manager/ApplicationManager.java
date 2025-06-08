package ru.stqa.addressbook.manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    public WebDriver driver;
    private LoginHelper session;
    public GroupHelper groups;


    public void init() {
        if (driver==null) {
            driver = new FirefoxDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.manage().window().setSize(new Dimension(1721, 1033));
            session.auth("admin", "secret");
        }
    }

    public LoginHelper session(){
        if(session==null) {
            session = new LoginHelper(this);
        }
        return session;
    }

    public GroupHelper groups(){
        if(groups==null) {
            groups = new GroupHelper(this);
        }
        return groups;
    }


}
