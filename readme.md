# Ecobank App

## Overview

The Ecobank App is a Java-based application that allows users to create a bank account, log in, check their balance, deposit funds, and withdraw funds. The program uses `JOptionPane` for user interactions, offering a simple graphical interface.

## Program Structure

The program is built around two main classes:

- **Main Class**: Contains the core logic, including account creation, login, balance checking, depositing, and withdrawing.
- **AccountCreation Class**: A parent class that handles user account details like name, ID, and PIN.

## Features

### Account Creation
- **User Info**: Collects first name, last name, and ID.
- **PIN Setup**: Prompts users to create a 4-digit PIN.
- **Unique Account Number**: Generates and assigns a unique account number to each user.

### Login Process
- Validates the user’s account number and PIN.
- Grants access to account operations upon successful login.

### Account Operations
- **Check Balance**: Displays the current account balance.
- **Deposit Funds**: Allows users to add funds to their account.
- **Withdraw Funds**: Enables users to withdraw money, ensuring sufficient balance.

## Main Application Flow

Upon launching the app, users are greeted with options to create a new account or log in as an existing customer. After logging in, they can check their balance, deposit, withdraw funds, or exit the application.

## Usage

To run the application, compile and execute the `Main` class in your preferred Java IDE (e.g., NetBeans, IntelliJ IDEA).
