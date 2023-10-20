package model;

import java.util.List;
import java.util.stream.Collectors;

public class AmountFilter implements TransactionFilter {
  private double amount;

  public AmountFilter(double amount) {
    this.amount = amount;
  }

  @Override
  public List<Transaction> filter(List<Transaction> transactions) {
    return transactions.stream()
      .filter(transaction -> transaction.getAmount() == amount)
      .collect(Collectors.toList());
  }
}