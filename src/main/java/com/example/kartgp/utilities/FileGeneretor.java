package com.example.kartgp.utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileGeneretor {
    public static void generateFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}