package com.rashiktimalsina.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfig {

    private static String URL;
    private static String USER;
    private static String PASSWORD;

    static {
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            Properties properties = new Properties();
            properties.load(fis);

            URL = properties.getProperty("db.url");
            USER = properties.getProperty("db.user");
            PASSWORD = properties.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load database configuration.");
        }
    }

    public static String getUrl() {
        return URL;
    }

    public static String getUser() {
        return USER;
    }

    public static String getPassword() {
        return PASSWORD;
    }
}
