package org.example.wc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("config.properties"));
            String filePath = properties.getProperty("file.path");

            int charCount = WordCounter.howManyCharsInTheFile(filePath);
            LOGGER.log(Level.INFO, () -> "Number of characters in the file: " + charCount);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Could not read configuration file", e);
        }
    }
}
