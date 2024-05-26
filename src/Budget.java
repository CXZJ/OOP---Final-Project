import java.util.Date;

public class Budget implements Manageable {
    private double budgetAmount;
    private Date startDate;
    private Date endDate;

    public Budget(double budgetAmount, Date startDate, Date endDate) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
