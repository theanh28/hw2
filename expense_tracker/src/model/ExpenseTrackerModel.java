package model;

import java.util.ArrayList;
import java.util.List;

public class ExpenseTrackerModel {

  private List<Transaction> transactions;

  public ExpenseTrackerModel() {
    transactions = new ArrayList<>(); 
  }

  public void addTransaction(Transaction t) {
    transactions.add(t);
  }

  public void removeTransaction(Transaction t) {
    transactions.remove(t);
  }

  // Returns copied transactions.
  public List<Transaction> getTransactions() {
    List<Transaction> copiedList = new ArrayList<>();

    // Copy the elements from the original list to the new list, with new copies created
    // to prevent modification of the original.
    for (Transaction transaction : transactions) {
      copiedList.add(new Transaction(transaction.getAmount(), transaction.getCategory()));
    }

    return copiedList;
  }

}