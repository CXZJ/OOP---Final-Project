import java.time.LocalDate;

public class Budget implements Manageable {
    private double budgetAmount;
    private LocalDate startDate;
    private LocalDate endDate;

    public Budget(double budgetAmount, LocalDate startDate, LocalDate endDate) {
        this.budgetAmount = budgetAmount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public void add() {
        // Implementation for adding a budget
    }

    @Override
    public void edit() {
        // Implementation for editing a budget
    }

    @Override
    public void delete() {
        // Implementation for deleting a budget
    }

    // Getter and Setter methods
    public double getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
