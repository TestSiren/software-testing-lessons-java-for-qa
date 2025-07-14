package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.stqa.addressbook.manager.ApplicationManager;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
   public static ApplicationManager app;

    @BeforeEach
    public void setUp() throws IOException {
        var properties = new Properties();
        properties.load(new FileReader(System.getProperty("target", "local.properties")));

        String browserFromConfig = properties.getProperty("browser", "firefox");
        String browser = System.getProperty("browser", browserFromConfig);

        if (app==null) {
            app = new ApplicationManager();
            app.init(browser);
        }
        app.session().auth(properties);
        ru.stqa.addressbook.dataproviders.GroupProvider.setGroupsFilePath(properties.getProperty("groups.data.file"));
        ru.stqa.addressbook.dataproviders.AddressProvider.setAddressFilePath(properties.getProperty("address.data.file"));
    }

    @AfterEach
    void checkDatabaseConsistency(){
        app.jdbc().checkConsistency();
    }
    public void tearDown() {
        app.session().logout();
    }
}
