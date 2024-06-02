import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PersonalFinanceManagerApp {
    private User user = new User();
    private JLabel totalBalanceLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PersonalFinanceManagerApp::new);
    }

    public PersonalFinanceManagerApp() {
        JFrame frame = new JFrame("Personal Finance Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLayout(new BorderLayout(10, 10));

        // Create panels for different sections
        JPanel budgetPanel = createBudgetPanel();
        JPanel transactionPanel = createTransactionPanel();
        JPanel goalPanel = createGoalPanel();

        // Add panels to the frame
        frame.add(budgetPanel, BorderLayout.WEST);
        frame.add(transactionPanel, BorderLayout.CENTER);
        frame.add(goalPanel, BorderLayout.EAST);

        // Create total balance display
        totalBalanceLabel = new JLabel("Total Balance: $0.00");
        totalBalanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalBalanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel balancePanel = new JPanel(new BorderLayout());
        balancePanel.add(totalBalanceLabel, BorderLayout.CENTER);
        balancePanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding around the label
        frame.add(balancePanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    private JPanel createTransactionPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Transactions"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding around the panel

        JLabel titleLabel = new JLabel("Transactions");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField amountField = new JTextField(10);
        JTextField descriptionField = new JTextField(10);
        JTextField dateField = new JTextField(10);
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Income", "Expense"});

        JButton addButton = new JButton("Add Transaction");
        JList<String> transactionList = new JList<>(new DefaultListModel<>());

        addButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String description = descriptionField.getText();
                LocalDate date = LocalDate.parse(dateField.getText());
                String type = (String) typeComboBox.getSelectedItem();

                Transaction transaction = new Transaction();

                assert type != null;
                if (type.equals("Income")) {
                    Income income = new Income(amount, description, date);
                    transaction.addIncome(income);
                    user.getTransactions().add(transaction);
                } else if (type.equals("Expense")) {
                    Expense expense = new Expense(amount, description, date);
                    transaction.addExpense(expense);
                    user.getTransactions().add(transaction);
                }

                refreshTransactionList((DefaultListModel<String>) transactionList.getModel());
                updateTotalBalance();
            } catch (NumberFormatException | DateTimeParseException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input. Please check the amount and date fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add components to the panel with padding
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical padding
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical padding
        panel.add(new JLabel("Description:"));
        panel.add(descriptionField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical padding
        panel.add(new JLabel("Date (YYYY-MM-DD):"));
        panel.add(dateField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical padding
        panel.add(new JLabel("Type:"));
        panel.add(typeComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical padding
        panel.add(addButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical padding
        panel.add(new JScrollPane(transactionList));

        return panel;
    }

    private JPanel createBudgetPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Budgets"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding around the panel

        JLabel titleLabel = new JLabel("Budgeting");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField amountField = new JTextField(10);
        JTextField startDateField = new JTextField(10);
        JTextField endDateField = new JTextField(10);

        JButton addButton = new JButton("Add Budget");
        JList<String> budgetList = new JList<>(new DefaultListModel<>());

        addButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                LocalDate startDate = LocalDate.parse(startDateField.getText());
                LocalDate endDate = LocalDate.parse(endDateField.getText());
                user.getBudgets().add(new Budget(amount, startDate, endDate));
                refreshBudgetList((DefaultListModel<String>) budgetList.getModel());
            } catch (NumberFormatException | DateTimeParseException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input. Please check the amount and date fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add components to the panel with padding
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical padding
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical padding
        panel.add(new JLabel("Start Date (YYYY-MM-DD):"));
        panel.add(startDateField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical padding
        panel.add(new JLabel("End Date (YYYY-MM-DD):"));
        panel.add(endDateField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical padding
        panel.add(addButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical padding
        panel.add(new JScrollPane(budgetList));

        return panel;
    }

    private JPanel createGoalPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Goals"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding around the panel

        JLabel titleLabel = new JLabel("Goals");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField nameField = new JTextField(10);
        JTextField amountField = new JTextField(10);

        JButton addButton = new JButton("Add Goal");
        JList<String> goalList = new JList<>(new DefaultListModel<>());

        addButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                double amount = Double.parseDouble(amountField.getText());
                user.getGoals().add(new Goal(name, amount));
                refreshGoalList((DefaultListModel<String>) goalList.getModel());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input. Please check the amount field.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add components to the panel with padding
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical padding
        panel.add(new JLabel("Goal Name:"));
        panel.add(nameField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical padding
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical padding
        panel.add(addButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add vertical padding
        panel.add(new JScrollPane(goalList));

        return panel;
    }

    private void refreshTransactionList(DefaultListModel<String> model) {
        model.clear();
        for (Transaction transaction : user.getTransactions()) {
            for (Account account : transaction.getAccounts()) {
                if (account instanceof Manageable) {
                    model.addElement(((Manageable) account).getDetails());
                }
            }
        }
    }

    private void refreshBudgetList(DefaultListModel<String> model) {
        model.clear();
        for (Budget budget : user.getBudgets()) {
            model.addElement(budget.getDetails());
        }
    }

    private void refreshGoalList(DefaultListModel<String> model) {
        model.clear();
        for (Goal goal : user.getGoals()) {
            model.addElement(goal.getDetails());
        }
    }

    private void updateTotalBalance() {
        double totalIncome = 0;
        double totalExpenses = 0;

        for (Transaction transaction : user.getTransactions()) {
            for (Income income : transaction.getIncomes()) {
                totalIncome += income.amount;
            }
            for (Expense expense : transaction.getExpenses()) {
                totalExpenses += expense.amount;
            }
        }

        double totalBalance = totalIncome - totalExpenses;
        totalBalanceLabel.setText(String.format("Total Balance: $%.2f", totalBalance));
    }
}
