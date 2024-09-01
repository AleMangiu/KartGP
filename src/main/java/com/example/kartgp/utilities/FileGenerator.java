package com.example.kartgp.utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileGenerator {

    private FileGenerator() {
        throw new IllegalStateException("Utility class");
    }

    public static void generateFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (Exception e) {
            throw new IllegalStateException("Utility");
        }
    }
}
