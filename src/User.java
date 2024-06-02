import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Transaction> transactions;
    private final List<Budget> budgets;
    private final List<Goal> goals;

    public User() {
        this.transactions = new ArrayList<>();
        this.budgets = new ArrayList<>();
        this.goals = new ArrayList<>();
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
