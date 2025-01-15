public class Expense {
    private double amount;
    private String category;
    private String description;
    private String date;  // Format could be "dd/MM/yyyy"
    
    // Constructor
    public Expense(double amount, String category, String description, String date) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    // Getter methods
    public double getAmount() {
        return amount;
    }
    public String getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public String getDate() {
        return date;
    }

    // To string method for displaying expense
    @Override
    public String toString() {
        return String.format("%s | %s | %.2f | %s", date, category, amount, description);
    }
}
