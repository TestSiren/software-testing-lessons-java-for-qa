package ru.stqa.addressbook.manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    protected WebDriver driver;
    private LoginHelper session;
    private GroupHelper groups;


    public void init(String browser) {
        if (driver==null) {
            if("firefox".equals(browser)) {
                driver = new FirefoxDriver();
            } else if ("chrome".equals(browser)) {
                driver = new ChromeDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.manage().window().setSize(new Dimension(1721, 1033));
            session().auth("admin", "secret");
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
