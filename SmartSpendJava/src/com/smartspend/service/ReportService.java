package com.smartspend.service;
import com.smartspend.model.Transaction;
import java.util.List;
public class ReportService {
    public void printReport(List<Transaction> transactions) {
        double income = 0;
        double expense = 0;
        System.out.println("\n=======================================================");
        System.out.println("                 FINANCIAL REPORT                      ");
        System.out.println("=======================================================");
        System.out.printf("%-12s | %-10s | %-10s | %s%n", "Date", "Type", "Amount", "Category");
        System.out.println("-------------------------------------------------------");
        if (transactions.isEmpty()) {
            System.out.println("             No transactions found.");
        }
        for (Transaction t : transactions) {
            System.out.printf("%-12s | %-10s | $%-9.2f | %s%n", 
                t.getDate(), t.getType(), t.getAmount(), t.getCategory());
            if (t.getType().equalsIgnoreCase("INCOME")) {
                income += t.getAmount();
            } else {
                expense += t.getAmount();
            }
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf(" TOTAL INCOME :  $%.2f%n", income);
        System.out.printf(" TOTAL EXPENSE:  $%.2f%n", expense);
        System.out.println("-------------------------------------------------------");
        System.out.printf(" NET BALANCE  :  $%.2f%n", (income - expense));
        System.out.println("=======================================================\n");
    }
}
