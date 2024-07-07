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
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
            String filePath = properties.getProperty("file.path");
            long charCount = WordCounter.howManyCharsInTheFile(filePath);
            long lineCount = WordCounter.howManyLinesInTheFile(filePath);
            long sizeInBytes = WordCounter.getFileSizeInBytes(filePath);
            long wordsCount = WordCounter.howManyWords(filePath);

            LOGGER.log(Level.INFO, () -> "Number of characters in the file: " + charCount);
            LOGGER.log(Level.INFO, () -> "Number of lines in the file: " + lineCount);
            LOGGER.log(Level.INFO, () -> "Number of words in the file: " + wordsCount);
            LOGGER.log(Level.INFO, () -> "Size of the file in bytes : " + sizeInBytes +" bytes");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Could not read configuration file", e);
        }
    }
}
