package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiConfig {
    private static final String PROPERTIES_FILE = "api.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = ApiConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
