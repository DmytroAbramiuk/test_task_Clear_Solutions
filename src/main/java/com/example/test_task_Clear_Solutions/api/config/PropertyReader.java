package com.example.test_task_Clear_Solutions.api.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public static Integer read(){
        Properties properties = new Properties();
        try {
            InputStream inputStream = PropertyReader.class.getResourceAsStream("/register.properties");
            properties.load(inputStream);
            return Integer.parseInt(properties.getProperty("register.age"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
