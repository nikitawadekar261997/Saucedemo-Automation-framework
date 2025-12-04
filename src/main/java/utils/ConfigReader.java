package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    // Load the properties only once
    public static Properties initProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    // Read a value by key
    public static String get(String key) {
        if (properties == null) {
            initProperties();
        }
        return properties.getProperty(key);
    }

}
