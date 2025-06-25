package ru.stqa.addressbook.common;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CommonFunctions {
    public static String randomString(int n) {
        var rnd = new Random();
        var result = "";
        for (int i = 0; i<n; i++)
        {
            result = result + (char)('a' + rnd.nextInt(26));
        }
        return result;
    }

    public static int randomDay() {
        var rnd = new Random();
        return (rnd.nextInt(31)+1);
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

    public static String randomFile(String dir) {
        var fileNames = new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length);

        return Paths.get(dir, fileNames[index]).toString();
    }
}
