package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class TestDataGenerator {

    private static Properties testData;

    // Load testdata.properties only once
    public static void initTestData() {
        if (testData == null) {
            testData = new Properties();
            try {
                FileInputStream fis = new FileInputStream("src/test/resources/testdata.properties");
                testData.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Get value from testdata.properties
    public static String get(String key) {
        if (testData == null) {
            initTestData();
        }
        return testData.getProperty(key);
    }

    // Optional: generate random numbers
    public static String randomNumber(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    // Optional: random name
    public static String randomName() {
        String[] names = {"Nikita", "Sara", "Priya", "Ananya", "Riya"};
        return names[new Random().nextInt(names.length)];
    }

}
