import java.time.LocalDate;

public abstract class Account {
    protected double amount;
    protected String description;
    protected LocalDate date;

    public Account(double amount, String description, LocalDate date) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }
}