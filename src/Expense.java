import java.time.LocalDate;

public class Expense extends Account {
    public Expense(double amount, String description, LocalDate date) {
        super(amount, description, date);
    }

    // Additional methods specific to Expense can be added here
}
