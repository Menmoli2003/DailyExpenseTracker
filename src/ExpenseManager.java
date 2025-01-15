import java.io.*;
import java.util.*;

public class ExpenseManager {
    private List<Expense> expenses;
    private String fileName;

    // Constructor
    public ExpenseManager(String fileName) {
        this.expenses = new ArrayList<>();
        this.fileName = fileName;
        loadExpenses();
    }

    // Add expense
    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveExpenses();
    }

    // Load expenses from file
    private void loadExpenses() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" \\| ");
                if (data.length == 4) {
                    double amount = Double.parseDouble(data[2]);
                    Expense expense = new Expense(amount, data[1], data[3], data[0]);
                    expenses.add(expense);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading expenses from file.");
        }
    }

    // Save expenses to file
    private void saveExpenses() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Expense expense : expenses) {
                writer.write(expense.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses to file.");
        }
    }

    // Display total expenses for a given time period
    public void displaySummary(String period) {
        double total = 0;
        for (Expense expense : expenses) {
            // Implement filtering based on date (day, week, month)
            // For now, display all expenses
            total += expense.getAmount();
        }
        System.out.printf("Total expenses for %s: %.2f\n", period, total);
    }

    // List all expenses
    public void listAllExpenses() {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }
}
