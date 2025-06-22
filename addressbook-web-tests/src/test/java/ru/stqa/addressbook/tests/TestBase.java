package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.stqa.addressbook.manager.ApplicationManager;

import java.util.Random;

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

    public static String randomString(int n) {
        var rnd = new Random();
        var result = "";
        for (int i = 0; i<n; i++)
        {
            result = result + (char)('a' + rnd.nextInt(26));
        }
        return result;
    }

    @AfterEach
    public void tearDown() {
        app.session().logout();
    }
}
