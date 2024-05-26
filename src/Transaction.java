import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private List<Income> incomes;
    private List<Expense> expenses;

    public Transaction() {
        this.incomes = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public void addIncome(Income income) {
        incomes.add(income);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        accounts.addAll(incomes);
        accounts.addAll(expenses);
        return accounts;
    }
}
