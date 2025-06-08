package ru.stqa.addressbook.steps;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.stqa.addressbook.manager.ApplicationManager;

public class TestBase {
   public static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        if (app==null) {
            app = new ApplicationManager();
        }
        app.init();
    }

    @AfterEach
    public void tearDown() {
        app.logout();
    }

}
