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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}