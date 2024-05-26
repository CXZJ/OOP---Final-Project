public class Goal implements Manageable {
    private String name;
    private double amount;

    public Goal(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Goal: %s - $%.2f", name, amount);
    }

    @Override
    public String getDetails() {
        return toString();
    }
}
