package controller;

import java.util.List;
import java.util.stream.Collectors;

import model.Transaction;

/**
 * This class represents a filter based on the transaction category.
 */
public class CategoryFilter implements TransactionFilter {
  private String category;

  /**
   * Constructs a new CategoryFilter with the specified category value.
   *
   * @param category the category value to be used for filtering
   */
  public CategoryFilter(String category) {
    this.category = category;
  }

  /**
   * Filters the list of transactions based on the category value.
   * @param transactions the list of transactions to be filtered
   * @return a list of transactions that match the specified category
   */
  @Override
  public List<Transaction> filter(List<Transaction> transactions) {
      return transactions.stream()
      .filter(transaction -> transaction.getCategory().equals(category))
      .collect(Collectors.toList());
  }
}