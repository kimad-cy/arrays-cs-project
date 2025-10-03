package samplearrays;

import java.util.ArrayList;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    ArrayList<Integer> transactions = new ArrayList<>(1000);

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if(amount < 0){
            System.out.println("Amount deposited cannot be negative");
        } else{
            currentBalance += amount;
            transactions.add(1);
            System.out.println("Depositer: " + name + ", Amount deposited: " + amount + ", Current balance is: " + currentBalance);
        }
    }

    public void withdraw(double amount){
        if(amount < 0){
            System.out.println("Amount cannot be negative");
        } else if(amount > currentBalance){
            System.out.println("Amount is greater than current balance");
        } else{
            currentBalance -= amount;
            transactions.add(-1);
            System.out.println("Amount withdrawed successfully. Current balance is: " + currentBalance);
        }
    }

    public void displayTransactions(){
        System.out.println("Transactions: { ");
        for (Integer i : transactions) {
            System.out.println(i);
        }
        System.out.println("}");
    }

    public void displayBalance(){
        System.out.println("Current balance is: " + currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
