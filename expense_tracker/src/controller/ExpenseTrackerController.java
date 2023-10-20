package controller;

import view.ExpenseTrackerView;

import java.util.List;

import model.AmountFilter;
import model.CategoryFilter;
import model.ExpenseTrackerModel;
import model.Transaction;
import model.TransactionFilter;
public class ExpenseTrackerController {
  
  private ExpenseTrackerModel model;
  private ExpenseTrackerView view;

  public ExpenseTrackerController(ExpenseTrackerModel model, ExpenseTrackerView view) {
    this.model = model;
    this.view = view;

    // Set up view event handlers
  }

  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = model.getTransactions();

    // Pass to view
    view.refreshTable(transactions);

  }

  public boolean addTransaction(double amount, String category) {
    if (!InputValidation.isValidAmount(amount)) {
      return false;
    }
    if (!InputValidation.isValidCategory(category)) {
      return false;
    }
    
    Transaction t = new Transaction(amount, category);
    model.addTransaction(t);
    view.getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
    return true;
  }
  
  // Other controller methods
  public boolean applyFilter() {
    TransactionFilter filter;
    String selectedFilterType = view.getSelectedFilterType();
    String filterValue = view.getFilterValue();
    if (selectedFilterType.equals("Amount")) {
      double filterAmount = Double.parseDouble(filterValue);
      if (!InputValidation.isValidAmount(filterAmount)) {
        return false;
      }
      filter = new AmountFilter(filterAmount);
    } else {
      if (!InputValidation.isValidCategory(filterValue)) {
        return false;
      }
      filter = new CategoryFilter(filterValue);
    }
    List<Transaction> filteredTransactions = filter.filter(model.getTransactions());
    view.refreshTable(model.getTransactions(), filteredTransactions); // This will highlight the rows in green (you can add this functionality in the `refreshTable` method)
    return true;
  }
}