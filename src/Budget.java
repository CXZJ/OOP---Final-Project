import java.time.LocalDate;

public class Budget implements Manageable {
    private double amount;
    private LocalDate startDate;
    private LocalDate endDate;

    public Budget(double amount, LocalDate startDate, LocalDate endDate) {
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return String.format("Budget: $%.2f from %s to %s", amount, startDate, endDate);
    }

    @Override
    public String getDetails() {
        return toString();
    }
}
