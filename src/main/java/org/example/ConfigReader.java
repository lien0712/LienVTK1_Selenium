package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    Properties prop = new Properties();

    public String getDataInput(String key) {
        try {
            String value;
            InputStream input = new FileInputStream("config.properties");
            prop.load(input);
            value = prop.getProperty(key);
            input.close();
            return value;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
