package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertiesUtils {
    private static Properties properties;

    static {
        try (FileInputStream fis = new FileInputStream("src/test/resources/application.properties")) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file!", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static List<String> getList(String key) {
        String value = properties.getProperty(key);
        return value != null ? Arrays.asList(value.split(",")) : null;
    }
}
