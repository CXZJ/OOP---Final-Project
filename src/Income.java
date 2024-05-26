import java.time.LocalDate;

public class Income extends Account {
    public Income(double amount, String description, LocalDate date) {
        super(amount, description, date);
    }

    @Override
    public String toString() {
        return String.format("%s: %s - $%.2f on %s", getClass().getSimpleName(), description, amount, date);
    }

    // Additional methods specific to Income can be added here
}
