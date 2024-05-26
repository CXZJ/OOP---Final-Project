public class Goal implements Manageable {
    private String goalName;
    private double goalAmount;
    private double savedAmount;

    public Goal(String goalName, double goalAmount) {
        this.goalName = goalName;
        this.goalAmount = goalAmount;
        this.savedAmount = 0;
    }

    @Override
    public void add() {
        // Implementation for adding a goal
    }

    @Override
    public void edit() {
        // Implementation for editing a goal
    }

    @Override
    public void delete() {
        // Implementation for deleting a goal
    }

    // Getter and Setter methods
    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public double getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(double goalAmount) {
        this.goalAmount = goalAmount;
    }

    public double getSavedAmount() {
        return savedAmount;
    }

    public void setSavedAmount(double savedAmount) {
        this.savedAmount = savedAmount;
    }

    public void addSavings(double amount) {
        this.savedAmount += amount;
    }
}
