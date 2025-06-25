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

    public static String randomFile(String userDir) {
        String currentDir = System.getProperty("user.userDir");
        String absolutePath = Paths.get(currentDir, userDir).toString();

        System.out.println("Resolved image directory: " + absolutePath);

        File folder = new File(absolutePath);
        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("Directory not found: " + folder.getAbsolutePath());
        }

        String[] fileNames = folder.list((dir, name) -> name.toLowerCase().endsWith(".jpg"));
        if (fileNames == null || fileNames.length == 0) {
            throw new IllegalArgumentException("No .jpg files found in: " + folder.getAbsolutePath());
        }

        int index = new Random().nextInt(fileNames.length);
        String result = Paths.get(absolutePath, fileNames[index]).toString();
        System.out.println("Selected file: " + result);

        return result;
    }

}
