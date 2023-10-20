package view;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.InputValidation;

import java.awt.*;
import java.text.NumberFormat;

import model.Transaction;
import java.util.List;

public class ExpenseTrackerView extends JFrame {

  private JTable transactionsTable;
  private JButton addTransactionBtn;
  private JButton applyFilterBtn;
  private JFormattedTextField amountField;
  private JTextField categoryField;
  private JComboBox<String> filterDropdown;
  private JTextField filterValue;
  private DefaultTableModel model;
  

  public ExpenseTrackerView() {
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger

    String[] columnNames = {"serial", "Amount", "Category", "Date"};
    this.model = new DefaultTableModel(columnNames, 0);

    addTransactionBtn = new JButton("Add Transaction");
    applyFilterBtn = new JButton("Apply Filter");

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    NumberFormat format = NumberFormat.getNumberInstance();

    amountField = new JFormattedTextField(format);
    amountField.setColumns(10);

    
    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);

    JLabel filterLabel = new JLabel("Filter by:");
    filterDropdown = new JComboBox<>(new String[]{"Amount", "Category"});
    filterValue = new JTextField(10);

    // Create table
    transactionsTable = new JTable(model);

    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel); 
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);

    JPanel filterPanel = new JPanel();
    filterPanel.add(filterLabel);
    filterPanel.add(filterDropdown);
    filterPanel.add(filterValue);
    filterPanel.add(applyFilterBtn);
  
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);
    buttonPanel.add(applyFilterBtn);
    
    JPanel composedPanel = new JPanel(new BorderLayout());
    composedPanel.add(inputPanel, BorderLayout.NORTH);
    composedPanel.add(filterPanel, BorderLayout.SOUTH);

    // Add panels to frame
    add(composedPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER); 
    add(buttonPanel, BorderLayout.SOUTH);
  
    // Set frame properties
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  
  }

  public void refreshTable(List<Transaction> transactions) {
    refreshTable(transactions, null);
  }

  public void refreshTable(List<Transaction> transactions, List<Transaction> filteredTransactions) {
      // Clear existing rows
      model.setRowCount(0);
      int rowNum = model.getRowCount();
      double totalCost = 0;
      // Calculate total cost
      for(Transaction t : transactions) {
        totalCost+=t.getAmount();
      }
      // Add rows from transactions list
      for (Transaction t : transactions) {
          model.addRow(new Object[]{rowNum+=1,t.getAmount(), t.getCategory(), t.getTimestamp()});
      }
      // Add total row
      Object[] totalRow = {"Total", null, null, totalCost};
      model.addRow(totalRow);

      transactionsTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                      boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (filteredTransactions != null && row < transactions.size()) {
                Transaction currentTransaction = new Transaction((Double) table.getValueAt(row, 1), (String) table.getValueAt(row, 2));
                if (filteredTransactions.contains(currentTransaction)) {
                    c.setBackground(new Color(173, 255, 168)); // Light green
                } else {
                    c.setBackground(table.getBackground());
                }
            }
            return c;
        }
      });
  }
    
  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }
  public JButton getApplyFilterBtn() {
    return applyFilterBtn;
  }
  public DefaultTableModel getTableModel() {
    return model;
  }
  // Other view methods
    public JTable getTransactionsTable() {
    return transactionsTable;
  }

  public double getAmountField() {
    if(amountField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(amountField.getText());
    return amount;
    }
  }

  public void setAmountField(JFormattedTextField amountField) {
    this.amountField = amountField;
  }

  
  public String getCategoryField() {
    return categoryField.getText();
  }

  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

  public String getSelectedFilterType() {
    return filterDropdown.getSelectedItem().toString();
  }

  public String getFilterValue() {
    return filterValue.getText();
  }
}
