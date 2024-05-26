import java.time.LocalDate;

public class PersonalFinanceManager {
    public static void main(String[] args) {
        User user = new User("John Doe");

        // Example of adding transactions
        Transaction transaction = new Transaction();
        Income income = new Income(1000.0, "Salary", LocalDate.now());
        Expense expense = new Expense(200.0, "Groceries", LocalDate.now());

        transaction.addIncome(income);
        transaction.addExpense(expense);

        user.getTransactions().add(transaction);

        // Example of adding a budget
        Budget budget = new Budget(1500.0, LocalDate.now(), LocalDate.now().plusMonths(1));
        user.getBudgets().add(budget);

        // Example of adding a goal
        Goal goal = new Goal("New Car", 20000.0);
        goal.addSavings(5000.0);
        user.getGoals().add(goal);

        // Output for verification
        System.out.println("User: " + user.getName());
        System.out.println("Transactions: " + user.getTransactions().size());
        System.out.println("Budgets: " + user.getBudgets().size());
        System.out.println("Goals: " + user.getGoals().size());
    }
}
