package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Transaction {

  private double amount;
  private String category;
  private String timestamp;

  public Transaction(double amount, String category) {
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  public double getAmount() {
    return amount;
  }

  // TODO: prevent extern mod = remove.
  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getCategory() {
    return category;
  }

  // TODO: prevent extern mod = remove.
  public void setCategory(String category) {
    this.category = category; 
  }
  
  public String getTimestamp() {
    return timestamp;
  }

  private String generateTimestamp() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
    return sdf.format(new Date());
  }

}