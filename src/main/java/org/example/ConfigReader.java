package org.example;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties properties = new Properties();

    public ConfigReader() {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if(inputStream !=null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("config.properties file not found");
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

        public String getProperty(String key) {
            return properties.getProperty(key);
        }
    }