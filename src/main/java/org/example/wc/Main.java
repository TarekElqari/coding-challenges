package org.example.wc;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        int charCount = WordCounter.howManyCharsInTheFile("C:\\Users\\Tarek-PC\\Desktop\\test.txt");
        LOGGER.log(Level.INFO, () -> "Number of characters in the file: " + charCount);
    }
}
