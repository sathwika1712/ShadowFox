import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class BankManagementSystem extends JFrame {

    JTextField nameField, amountField;
    JButton addBtn, depositBtn, withdrawBtn, deleteBtn, updateBtn;
    JTable table;
    DefaultTableModel model;

    public BankManagementSystem() {

        setTitle("Advanced Bank Management System");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(44, 62, 80));

        // Title
        JLabel title = new JLabel("Bank Management System");
        title.setBounds(200, 10, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        panel.add(title);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 60, 100, 25);
        nameLabel.setForeground(Color.WHITE);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 60, 150, 25);
        panel.add(nameField);

        // Amount
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(50, 100, 100, 25);
        amountLabel.setForeground(Color.WHITE);
        panel.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(150, 100, 150, 25);
        panel.add(amountField);

        // Buttons
        addBtn = new JButton("Add Account");
        addBtn.setBounds(350, 60, 150, 30);
        addBtn.setBackground(Color.GREEN);
        addBtn.setForeground(Color.WHITE);
        panel.add(addBtn);

        depositBtn = new JButton("Deposit");
        depositBtn.setBounds(50, 150, 120, 30);
        depositBtn.setBackground(Color.BLUE);
        depositBtn.setForeground(Color.WHITE);
        panel.add(depositBtn);

        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(200, 150, 120, 30);
        withdrawBtn.setBackground(Color.RED);
        withdrawBtn.setForeground(Color.WHITE);
        panel.add(withdrawBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(350, 150, 120, 30);
        updateBtn.setBackground(Color.ORANGE);
        updateBtn.setForeground(Color.WHITE);
        panel.add(updateBtn);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(500, 150, 120, 30);
        deleteBtn.setBackground(Color.DARK_GRAY);
        deleteBtn.setForeground(Color.WHITE);
        panel.add(deleteBtn);

        // Table
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Balance");

        table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(50, 200, 600, 200);
        panel.add(pane);

        // EVENTS

        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            String amount = amountField.getText();

            if (!name.isEmpty() && !amount.isEmpty()) {
                model.addRow(new Object[]{name, Double.parseDouble(amount)});
                clearFields();
            }
        });

        depositBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                double current = (double) model.getValueAt(row, 1);
                double amt = Double.parseDouble(amountField.getText());
                model.setValueAt(current + amt, row, 1);
                clearFields();
            }
        });

        withdrawBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                double current = (double) model.getValueAt(row, 1);
                double amt = Double.parseDouble(amountField.getText());

                if (amt <= current) {
                    model.setValueAt(current - amt, row, 1);
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient Balance");
                }
                clearFields();
            }
        });

        updateBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                model.setValueAt(nameField.getText(), row, 0);
                model.setValueAt(Double.parseDouble(amountField.getText()), row, 1);
                clearFields();
            }
        });

        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                model.removeRow(row);
            }
        });

        // Fill fields on row click
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                nameField.setText(model.getValueAt(row, 0).toString());
                amountField.setText(model.getValueAt(row, 1).toString());
            }
        });

        add(panel);
        setVisible(true);
    }

    void clearFields() {
        nameField.setText("");
        amountField.setText("");
    }

    public static void main(String[] args) {
        new BankManagementSystem();
    }
}
