package controller;

import java.util.List;

import model.Transaction;

/**
 * Represents a filter strategy for transactions.
 */
public interface TransactionFilter {
  /**
   * Filters the given list of transactions based on specific criteria.
   *
   * @param transactions The list of transactions to be filtered.
   * @return A list of transactions that match the filter criteria.
   */
  List<Transaction> filter(List<Transaction> transactions);
}