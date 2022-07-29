package com.training.Bankingsystemfinal.dto;

public class ShowBalanceDTO {
    private String accountNo;
    private int balance;

    public ShowBalanceDTO() {
    }

    public ShowBalanceDTO(String accountNo) {
        this.accountNo = accountNo;
    }

    public ShowBalanceDTO(String accountNo, int balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

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
}
