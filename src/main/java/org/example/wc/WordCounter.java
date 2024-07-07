package org.example.wc;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordCounter {
    private static final Logger LOGGER = Logger.getLogger(WordCounter.class.getName());

    public static int howManyCharsInTheFile(String pathToFile) {
        int charsCounter = 0;
        try (FileReader fr = new FileReader(pathToFile)) {
            int charRead;
            // Read each character until the end of the file is reached
            while ((charRead = fr.read()) != -1) {
                // Check if the character is not a whitespace
                if (!Character.isWhitespace((char) charRead)) {
                    charsCounter++;
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, () -> "An error occurred while reading the file: " + e.getMessage());
        }
        return charsCounter;
    }
}
