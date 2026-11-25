package com.bank.app;

import com.bank.exceptions.InsufficientFundsException;
import com.bank.exceptions.InvalidAmountException;
import com.bank.service.BankAccount;

public class TransactionApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Lucia Odhong", 250000);

        // 1. Handling Custom Exceptions (try - multi-catch - finally)
        try {
            account.deposit(50000);
            account.withdraw(400000); // Exceeds UGX 300,000 balance
        } catch (InvalidAmountException e) {
            System.out.println("[Validation Error] " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("[Funds Error] " + e.getMessage() + " Shortfall: UGX " + e.getShortfall());
        } finally {
            System.out.println("[Audit Log] Account balance check completed. Current Balance: UGX " + account.getBalance());
        }
    }
}