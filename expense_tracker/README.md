# hw1- Manual Review

The homework will be based on this project named "Expense Tracker",where users will be able to add/remove daily transaction. 

## Compile

To compile the code from terminal, use the following command:
```
cd src
javac ExpenseTrackerApp.java
java ExpenseTracker
```

You should be able to view the GUI of the project upon successful compilation. 

## Java Version
This code is compiled with ```openjdk 17.0.7 2023-04-18```. Please update your JDK accordingly if you face any incompatibility issue.

## New functionality
Modularity for Transaction and ExpenseTrackerModel.

### Extensibility - Transaction Filtering:

- **Amount Filter**: 
  - Users can now filter transactions based on a specific amount. 
  - This helps in quickly identifying all transactions of a particular value.

- **Category Filter**: 
  - Users can filter transactions based on their category. 
  - This is useful for users looking to review all transactions under a specific category, such as "food" or "travel".