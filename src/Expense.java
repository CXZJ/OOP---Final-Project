import java.time.LocalDate;

public class Expense extends Account implements Manageable {
    public Expense(double amount, String description, LocalDate date) {
        super(amount, description, date);
    }

    @Override
    public String toString() {
        return String.format("Expense: %s - $%.2f on %s", description, amount, date);
    }

    @Override
    public String getDetails() {
        return toString();
    }
}
