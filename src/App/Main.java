package App;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class Main extends AccountCreation {

    private static Set<String> accountNumbers = new HashSet<>(); // Store unique account numbers
    private double balance;
    
    public Main() {
        this.balance = 0.0; 
    }
    
    @Override
    void createAccount() {
        // Collect user info
        String name = JOptionPane.showInputDialog("Enter your first name"); 
        String lastName = JOptionPane.showInputDialog("Enter your last name");
        String id = JOptionPane.showInputDialog("Enter your identification number");

        // Assign user info
        setName(name);
        setLastName(lastName);
        setId(id);

        // Create a unique PIN
        String pin = JOptionPane.showInputDialog("Create a 4-digit PIN:");
        setPin(pin);

        // Generate and assign a unique account number
        setAccountNumber(generateUniqueAccountNumber());

        JOptionPane.showMessageDialog(null, "Thank you for creating your account at Ecobank! Your account number is " + getAccountNumber());
    }

    private String generateUniqueAccountNumber() {
        String accountNumber;
        do {
            long randomNumber = (long) (Math.random() * 100000L);
            accountNumber = "ECO" + String.format("%05d", randomNumber);
        } while (accountNumbers.contains(accountNumber)); // Ensure the account number is unique

        accountNumbers.add(accountNumber); // Add the new account number to the set
        return accountNumber;
    }

    public boolean login() {
    	
  	
        // Prompt the user to enter their account number
        String accountNum = JOptionPane.showInputDialog("Enter your account number:");
        
        // Prompt the user to enter their PIN
        String enteredPin = JOptionPane.showInputDialog("Enter your PIN:");

        // Check if the entered account number and PIN match the stored ones
        if (accountNum.equals(getAccountNumber()) && enteredPin.equals(getPin())) {
            JOptionPane.showMessageDialog(null, "Login successful!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect account number or PIN.");
            return false;
        }

    }
    
    
    private void checkBalance() {
        JOptionPane.showMessageDialog(null, "Your current balance is $" + String.format("%.2f", balance));
    }

    private void depositFunds() {
        String depositStr = JOptionPane.showInputDialog("Enter amount to deposit:");
        if (depositStr != null) {
            double deposit = Double.parseDouble(depositStr);
            if (deposit > 0) {
                balance += deposit;
                JOptionPane.showMessageDialog(null, "You've deposited $" + deposit + ". Your new balance is $" + String.format("%.2f", balance));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid deposit amount.");
            }
        }
    }

    private void withdrawFunds() {
        String withdrawalStr = JOptionPane.showInputDialog("Enter amount to withdraw:");
        if (withdrawalStr != null) {
            double withdrawal = Double.parseDouble(withdrawalStr);
            if (withdrawal > 0 && withdrawal <= balance) {
                balance -= withdrawal;
                JOptionPane.showMessageDialog(null, "You've withdrawn $" + withdrawal + ". Your new balance is $" + String.format("%.2f", balance));
            } else if (withdrawal > balance) {
                JOptionPane.showMessageDialog(null, "Insufficient funds. Your current balance is $" + String.format("%.2f", balance));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid withdrawal amount.");
            }
        }
    }

    public static void main(String[] args) {
        boolean welcome = true;
        boolean loggedIn = false;
        Main account = new Main();

        while (welcome) {
            // Initial welcome options for new or existing customers
            String[] options1 = {"New customer? Create your account now 😉", "Log in to your Ecobank App now!"};
            int choose = JOptionPane.showOptionDialog(
                    null,
                    "Welcome to the Ecobank App!",
                    "Please choose an option:",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options1,
                    options1[0]
            );

            if (choose == 0) {
                // New customer flow
                account.createAccount();
                account.login();
            }else if (account.login() == true) {
            	loggedIn = true;
            }else if (choose == 1) {
                // Existing customer flow
                loggedIn = account.login();
            } else {
                welcome = false;
                break;
            }

            if (loggedIn) {
                while (true) {
                    String[] options = {"Check Balance", "Deposit Funds", "Withdraw Funds", "Exit"};
                    int choice = JOptionPane.showOptionDialog(
                            null,
                            "Welcome to the Ecobank App! Please choose an option:",
                            "Ecobank App Menu",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            options,
                            options[0]
                    );

                    switch (choice) {
                        case 0:
                            account.checkBalance();
                            break;
                        case 1:
                            account.depositFunds();
                            break;
                        case 2:
                            account.withdrawFunds();
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Thank you for using the Ecobank App. Goodbye!");
                            welcome = false;
                            break;
                        default:
                            welcome = false;
                            break;
                    }

                    if (!welcome) {
                        break;
                    }
                }
            }
        }
    }
}