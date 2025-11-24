package com.smartspend;
import com.smartspend.model.User;
import com.smartspend.model.Transaction;
import com.smartspend.service.AuthService;
import com.smartspend.service.ReportService;
import com.smartspend.service.TransactionService;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AuthService authService = new AuthService();
    private static TransactionService transService = new TransactionService();
    private static ReportService reportService = new ReportService();
    private static User currentUser = null;
    public static void main(String[] args) {
        System.out.println("Welcome to SmartSpend Console Manager");
        while (true) {
            if (currentUser == null) {
                showAuthMenu();
            } else {
                showUserMenu();
            }
        }
    }
    private static void showAuthMenu() {
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Choose: ");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            System.out.print("Username: ");
            String user = scanner.nextLine();
            System.out.print("Password: ");
            String pass = scanner.nextLine();
            currentUser = authService.login(user, pass);
            if (currentUser == null) System.out.println("Invalid credentials!");
            else System.out.println("Login successful!");
        } else if (choice.equals("2")) {
            System.out.print("New Username: ");
            String user = scanner.nextLine();
            System.out.print("New Password: ");
            String pass = scanner.nextLine();
            if (authService.register(user, pass)) System.out.println("Registered! Please login.");
            else System.out.println("Username exists.");
        } else if (choice.equals("3")) {
            System.exit(0);
        }
    }
    private static void showUserMenu() {
        System.out.println("\nDashboard for: " + currentUser.getUsername());
        System.out.println("1. Add Income");
        System.out.println("2. Add Expense");
        System.out.println("3. View Report");
        System.out.println("4. Logout");
        System.out.print("Choose: ");
        String choice = scanner.nextLine();
        if (choice.equals("1") || choice.equals("2")) {
            String type = choice.equals("1") ? "INCOME" : "EXPENSE";
            System.out.print("Amount: ");
            try {
                double amt = Double.parseDouble(scanner.nextLine());
                System.out.print("Category (e.g., Food, Salary): ");
                String cat = scanner.nextLine();
                transService.addTransaction(currentUser.getUsername(), amt, type, cat);
                System.out.println("Transaction added.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount.");
            }
        } else if (choice.equals("3")) {
            List<Transaction> list = transService.getUserTransactions(currentUser.getUsername());
            reportService.printReport(list);
        } else if (choice.equals("4")) {
            currentUser = null;
            System.out.println("Logged out.");
        }
    }
}