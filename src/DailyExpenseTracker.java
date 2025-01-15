import java.util.Scanner;

public class DailyExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager("expenses.txt");

        while (true) {
            System.out.println("\n--- Daily Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Daily Summary");
            System.out.println("3. View Weekly Summary");
            System.out.println("4. View Monthly Summary");
            System.out.println("5. View All Expenses");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter date (dd/MM/yyyy): ");
                    String date = scanner.nextLine();

                    Expense expense = new Expense(amount, category, description, date);
                    manager.addExpense(expense);
                    System.out.println("Expense added successfully!");
                    break;


                case 2:
                    manager.displaySummary("day");
                    break;

                case 3:
                    manager.displaySummary("week");
                    break;

                case 4:
                    manager.displaySummary("month");
                    break;

                case 5:
                    manager.listAllExpenses();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        
    }
    
}
