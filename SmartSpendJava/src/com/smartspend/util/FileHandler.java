package com.smartspend.util;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileHandler {
    private static final String USER_FILE = "users.txt";
    private static final String TRANS_FILE = "transactions.csv";
    public static void saveUser(String data) throws IOException {
        appendToFile(USER_FILE, data);
    }
    public static List<String> readUsers() {
        return readFile(USER_FILE);
    }
    public static void saveTransaction(String data) throws IOException {
        appendToFile(TRANS_FILE, data);
    }
    public static List<String> readTransactions() {
        return readFile(TRANS_FILE);
    }
    private static void appendToFile(String fileName, String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(data);
            writer.newLine();
        }
    }
    private static List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) return lines;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return lines;
    }
}