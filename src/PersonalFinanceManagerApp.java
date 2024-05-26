import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PersonalFinanceManagerApp {
    private User user = new User("John Doe");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PersonalFinanceManagerApp::new);
    }

    public PersonalFinanceManagerApp() {
        JFrame frame = new JFrame("Personal Finance Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Create panels for different sections
        JPanel transactionPanel = createTransactionPanel();
        JPanel budgetPanel = createBudgetPanel();
        JPanel goalPanel = createGoalPanel();

        // Add panels to the frame
        frame.add(transactionPanel, BorderLayout.WEST);
        frame.add(budgetPanel, BorderLayout.CENTER);
        frame.add(goalPanel, BorderLayout.EAST);

        frame.setVisible(true);
    }

    private JPanel createTransactionPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Transactions"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around the panel

        JTextField amountField = new JTextField(10);
        JTextField descriptionField = new JTextField(10);
        JTextField dateField = new JTextField(10);
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Income", "Expense"});

        JButton addButton = new JButton("Add Transaction");
        JList<String> transactionList = new JList<>(new DefaultListModel<>());

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String description = descriptionField.getText();
                    LocalDate date = LocalDate.parse(dateField.getText());
                    String type = (String) typeComboBox.getSelectedItem();

                    Transaction transaction = new Transaction();

                    if (type.equals("Income")) {
                        transaction.addIncome(new Income(amount, description, date));
                    } else if (type.equals("Expense")) {
                        transaction.addExpense(new Expense(amount, description, date));
                    }

                    user.getTransactions().add(transaction);
                    refreshTransactionList((DefaultListModel<String>) transactionList.getModel());
                } catch (NumberFormatException | DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(panel, "Invalid input. Please check the amount and date fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add components to the panel with padding
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
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around the panel

        JTextField amountField = new JTextField(10);
        JTextField startDateField = new JTextField(10);
        JTextField endDateField = new JTextField(10);

        JButton addButton = new JButton("Add Budget");
        JList<String> budgetList = new JList<>(new DefaultListModel<>());

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    LocalDate startDate = LocalDate.parse(startDateField.getText());
                    LocalDate endDate = LocalDate.parse(endDateField.getText());
                    user.getBudgets().add(new Budget(amount, startDate, endDate));
                    refreshBudgetList((DefaultListModel<String>) budgetList.getModel());
                } catch (NumberFormatException | DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(panel, "Invalid input. Please check the amount and date fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add components to the panel with padding
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
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around the panel

        JTextField nameField = new JTextField(10);
        JTextField amountField = new JTextField(10);

        JButton addButton = new JButton("Add Goal");
        JList<String> goalList = new JList<>(new DefaultListModel<>());

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    double amount = Double.parseDouble(amountField.getText());
                    user.getGoals().add(new Goal(name, amount));
                    refreshGoalList((DefaultListModel<String>) goalList.getModel());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Invalid input. Please check the amount field.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add components to the panel with padding
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
                model.addElement(account.toString());
            }
        }
    }

    private void refreshBudgetList(DefaultListModel<String> model) {
        model.clear();
        for (Budget budget : user.getBudgets()) {
            model.addElement(budget.toString());
        }
    }

    private void refreshGoalList(DefaultListModel<String> model) {
        model.clear();
        for (Goal goal : user.getGoals()) {
            model.addElement(goal.toString());
        }
    }
}
