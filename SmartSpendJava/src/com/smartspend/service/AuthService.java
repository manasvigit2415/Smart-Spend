package com.smartspend.service;
import com.smartspend.model.User;
import com.smartspend.util.FileHandler;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;
public class AuthService {
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Hashing failed");
        }
    }
    public boolean register(String username, String password) {
        List<String> users = FileHandler.readUsers();
        for (String line : users) {
            if (line.split(",")[0].equals(username)) return false;
        }
        try {
            String entry = username + "," + hashPassword(password);
            FileHandler.saveUser(entry);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public User login(String username, String password) {
        String inputHash = hashPassword(password);
        List<String> users = FileHandler.readUsers();
        for (String line : users) {
            String[] parts = line.split(",");
            if (parts.length >= 2) {
                if (parts[0].equals(username) && parts[1].equals(inputHash)) {
                    return new User(username, inputHash);
                }
            }
        }
        return null;
    }
}