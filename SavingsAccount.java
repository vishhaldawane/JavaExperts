package com.thothit;

import java.io.Serializable;

//now your object is qualified to store its data to the disk, cuase of Serializable
public class SavingsAccount implements Serializable {
    private int accountNumber;
    private String accountHolder;
    private double accountBalance;
    private transient int pinNumber; //should not serialize
    private static int countOfSavingsAccount; //should not serialize

    public SavingsAccount(int accountNumber, String accountHolder, double accountBalance, int pinNumber) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
        this.pinNumber = pinNumber;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber=" + accountNumber +
                ", accountHolder='" + accountHolder + '\'' +
                ", accountBalance=" + accountBalance +
                ", pinNumber=" + pinNumber +
                '}';
    }
}
