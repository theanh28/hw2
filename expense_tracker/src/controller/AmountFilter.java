package controller;

import java.util.List;
import java.util.stream.Collectors;

import model.Transaction;

/**
 * This class represents a filter based on the transaction amount.
 */
public class AmountFilter implements TransactionFilter {
  private double amount;

  /**
   * Constructs a new AmountFilter with the specified amount value.
   *
   * @param amount the amount value to be used for filtering
   */
  public AmountFilter(double amount) {
    this.amount = amount;
  }

  /**
   * Filters the list of transactions based on the amount value.
   * @param transactions the list of transactions to be filtered
   * @return a list of transactions that match the specified amount
   */
  @Override
  public List<Transaction> filter(List<Transaction> transactions) {
    return transactions.stream()
      .filter(transaction -> transaction.getAmount() == amount)
      .collect(Collectors.toList());
  }
}