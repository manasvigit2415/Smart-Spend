package com.smartspend.service;
import com.smartspend.model.Transaction;
import com.smartspend.util.FileHandler;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class TransactionService {
    public void addTransaction(String username, double amount, String type, String category) {
        try {
            Transaction t = new Transaction(username, amount, type, category, LocalDate.now().toString());
            FileHandler.saveTransaction(t.toCSV());
        } catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }
    public List<Transaction> getUserTransactions(String username) {
        List<String> rawData = FileHandler.readTransactions();
        List<Transaction> userTrans = new ArrayList<>();
        for (String line : rawData) {
            String[] p = line.split(",");
            if (p.length == 5 && p[0].equals(username)) {
                try {
                    userTrans.add(new Transaction(
                        p[0], 
                        Double.parseDouble(p[1]), 
                        p[2], 
                        p[3], 
                        p[4]
                    ));
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        return userTrans;
    }
}