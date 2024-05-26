import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Transaction> transactions;
    private List<Budget> budgets;
    private List<Goal> goals;

    public User(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.budgets = new ArrayList<>();
        this.goals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Budget> getBudgets() {
        return budgets;
    }

    public List<Goal> getGoals() {
        return goals;
    }
}
