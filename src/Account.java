import java.util.Date;

public abstract class Account {
    protected double amount;
    protected String description;
    protected Date date;

    public Account(double amount, String description, Date date) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    // Getter and setter methods
}