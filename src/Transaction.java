import java.util.ArrayList;

public class Transaction implements Manageable {
    private ArrayList<Account> accounts;

    public Transaction() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public void add() {
        // Implementation for adding a transaction
    }

    @Override
    public void edit() {
        // Implementation for editing a transaction
    }

    @Override
    public void delete() {
        // Implementation for deleting a transaction
    }

    // Methods to manage income and expense transactions
    public void addIncome(Income income) {
        accounts.add(income);
    }

    public void addExpense(Expense expense) {
        accounts.add(expense);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
