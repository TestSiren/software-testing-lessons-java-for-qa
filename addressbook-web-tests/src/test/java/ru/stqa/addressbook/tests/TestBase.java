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
        properties.load(new FileReader(System.getProperty("target", "local.propreties")));
        if (app==null) {
            app = new ApplicationManager();
            app.init(System.getProperty("browser", "firefox"));
        }
        app.session().auth(properties);
    }

    @AfterEach
    public void tearDown() {
        app.session().logout();
    }
}
