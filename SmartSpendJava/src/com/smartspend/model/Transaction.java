package com.smartspend.model;
public class Transaction {
    private String username;
    private double amount;
    private String type; 
    private String category;
    private String date;
    public Transaction(String username, double amount, String type, String category, String date) {
        this.username = username;
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.date = date;
    }
    public String getUsername() { return username; }
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public String getCategory() { return category; }
    public String getDate() { return date; }
    @Override
    public String toString() {
        return date + " | " + type + " | $" + amount + " | " + category;
    }
    public String toCSV() {
        return username + "," + amount + "," + type + "," + category + "," + date;
    }
}