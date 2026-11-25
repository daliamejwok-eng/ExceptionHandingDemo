package com.bank.service;

import com.bank.exceptions.InsufficientFundsException;
import com.bank.exceptions.InvalidAmountException;

public class BankAccount {
    private final String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be greater than UGX 0.");
        }
        balance += amount;
        System.out.println("Deposited UGX " + amount + " | New Balance: UGX " + balance);
    }
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount cannot be zero or negative.");
        }
        if (amount > balance) {
            double deficit = amount - balance;
            throw new InsufficientFundsException("Transaction declined: Insufficient balance.", deficit);
        }
        balance -= amount;
        System.out.println("Withdrew UGX " + amount + " | Remaining Balance: UGX " + balance);
    }

    public void splitPayment(double totalAmount, int numberOfPeople) {
        int share = (int) totalAmount / numberOfPeople; // Triggers ArithmeticException if 0
        System.out.println("Each person pays: UGX " + share);
    }

    public double getBalance() {
        return balance;
    }
}

