package ru.stqa.addressbook.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.stqa.addressbook.manager.ApplicationManager;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class TestBase {
    public static ApplicationManager app;

    @BeforeEach
    public void setUp() throws IOException {
        var properties = new Properties();
        properties.load(new FileReader(System.getProperty("target", "local.properties")));

        String browserFromConfig = properties.getProperty("browser", "firefox");
        String browser = System.getProperty("browser", browserFromConfig);

        if (app == null) {
            app = new ApplicationManager();
            app.init(browser);
        }
        app.session().auth(properties);

        ru.stqa.addressbook.dataproviders.GroupProvider.setGroupsFilePath(properties.getProperty("groups.data.file"));
        ru.stqa.addressbook.dataproviders.AddressProvider.setAddressFilePath(properties.getProperty("address.data.file"));
    }

    @AfterEach
    public void tearDown() {
        app.session().logout();
    }
    public static String randomString(int n) {
        var rnd = new Random();
        var result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append((char) ('a' + rnd.nextInt(26)));
        }
        return result.toString();
    }

    public static int randomDay() {
        var rnd = new Random();
        return rnd.nextInt(31) + 1;
    }

    public static String randomYear() {
        var rnd = new Random();
        return String.valueOf(rnd.nextInt(2015 - 1900 + 1) + 1900);
    }

    public static String randomMonths() {
        var rnd = new Random();
        List<String> months = Arrays.asList(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
        return months.get(rnd.nextInt(months.size()));
    }
}
