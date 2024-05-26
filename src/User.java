import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Transaction> transactions;
    private ArrayList<Budget> budgets;
    private ArrayList<Goal> goals;

    public User(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.budgets = new ArrayList<>();
        this.goals = new ArrayList<>();
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public ArrayList<Budget> getBudgets() {
        return budgets;
    }

    public ArrayList<Goal> getGoals() {
        return goals;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", transactions=" + transactions +
                ", budgets=" + budgets +
                ", goals=" + goals +
                '}';
    }

    // Additional methods for managing transactions, budgets, and goals
}
