package com.training.Bankingsystemfinal.dto;

public class WithdrawalDTO {
    private int balance;
    private String accountNo;

    private int amount;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public WithdrawalDTO() {
    }

    public WithdrawalDTO(String accountNo, int balance) {
        this.balance = balance;
        this.accountNo = accountNo;
    }
}
