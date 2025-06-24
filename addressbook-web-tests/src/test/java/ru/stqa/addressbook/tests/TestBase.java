package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.stqa.addressbook.manager.ApplicationManager;

import java.util.Arrays;
import java.util.List;
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
    public static int randomInt(String type) {
        var rnd = new Random();
        var result = 0;
        if (type.equals("day")) {
            result = rnd.nextInt(31)+1;
        } else if (type.equals("year")) {
            result = rnd.nextInt(2015 - 1900 + 1) + 1900;
        } else {
            result = rnd.nextInt(10000);
        }
        return result;
    }
    public static String randomYear() {
        var rnd = new Random();
        var result = String.valueOf((rnd.nextInt(2015 - 1900 + 1) + 1900));
        //Если преобразовать через char, то получается спец символ юникода, а не год.
        return result;
    }
    public static String randomMonths() {
        var rnd = new Random();
            List<String> months = Arrays.asList(
                    "January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"
            );
        return months.get(rnd.nextInt(months.size()));
    }

    @AfterEach
    public void tearDown() {
        app.session().logout();
    }
}
