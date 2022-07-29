package com.training.Bankingsystemfinal.dto;

public class DepositDTO {

   private String accountNo;

   private int amount;
   private int balance;
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public DepositDTO() {
    }

    public DepositDTO(String accountNo, int balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }
}
