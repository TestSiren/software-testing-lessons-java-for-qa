package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.stqa.addressbook.manager.ApplicationManager;

public class TestBase {
   public static ApplicationManager app;

    @BeforeEach
    public void setUp() throws InterruptedException {
        if (app==null) {
            app = new ApplicationManager();
            app.init(System.getProperty("browser", "firefox"));
        }
        app.session().auth("admin", "secret");
    }

    @AfterEach
    public void tearDown() {
        app.session().logout();
    }
}
