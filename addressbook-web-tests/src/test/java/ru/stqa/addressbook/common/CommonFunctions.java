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
    public static String randomFile(String relativeDir) {
        String projectRoot = Paths.get("").toAbsolutePath().toString();

        System.out.println("user.dir = " + projectRoot);

        if (projectRoot == null) {
            throw new IllegalStateException("System property 'user.dir' is null");
        }

        if (relativeDir == null) {
            throw new IllegalArgumentException("Argument 'relativeDir' cannot be null");
        }

        File folder = new File(projectRoot, relativeDir);
        System.out.println("Looking in folder: " + folder.getAbsolutePath());

        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("Directory not found: " + folder.getAbsolutePath());
        }

        String[] fileNames = folder.list((d, name) -> name.toLowerCase().endsWith(".jpg"));

        if (fileNames == null || fileNames.length == 0) {
            throw new IllegalArgumentException("No .jpg files found in: " + folder.getAbsolutePath());
        }

        int index = new Random().nextInt(fileNames.length);
        String selectedFile = new File(folder, fileNames[index]).getAbsolutePath();
        System.out.println("Selected file: " + selectedFile);
        return selectedFile;
    }
    }

