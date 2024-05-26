import java.time.LocalDate;

public class Income extends Account implements Manageable {
    public Income(double amount, String description, LocalDate date) {
        super(amount, description, date);
    }

    @Override
    public String toString() {
        return String.format("Income: %s - $%.2f on %s", description, amount, date);
    }

    @Override
    public String getDetails() {
        return toString();
    }
}
