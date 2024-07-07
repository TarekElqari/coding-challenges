package org.example.wc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordCounter {
    private static final Logger LOGGER = Logger.getLogger(WordCounter.class.getName());
    public static long howManyCharsInTheFile(String filePath) {
        long charsCounter = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            long charRead;
            while ((charRead = br.read()) != -1) {
                if (!Character.isWhitespace((char) charRead)) {
                    charsCounter++;
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, () -> "An error occurred while reading the file: " + e.getMessage());
        }
        return charsCounter;
    }
    public static long howManyLinesInTheFile(String filePath) {
        long lineCounter = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    lineCounter++;
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, () -> "An error occurred while reading the file: " + e.getMessage());
        }
        return lineCounter;
    }
    public static long howManyWords(String filePath) {
        long numberOfWords = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                numberOfWords += words.length;
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, () -> "An error occurred while reading the file: " + e.getMessage());
        }
        return numberOfWords;
    }
    public static long getFileSizeInBytes(String filePath) {
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            return file.length();
        } else {
            throw new IllegalArgumentException("File does not exist or is not a regular file: " + filePath);
        }
    }
}

