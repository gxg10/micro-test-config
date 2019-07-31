package com.example.bankaccountservice;

import java.math.BigDecimal;

public class BankAccount {

    private String accountId;

    private String accountName;

    private EnumAccountType accountType;

    private BigDecimal accountBalance;

    public BankAccount() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public EnumAccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(EnumAccountType accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBlance(BigDecimal accountBlance) {
        this.accountBalance = accountBlance;
    }

    public BankAccount(String accountId, String accountName, EnumAccountType accountType, BigDecimal accountBlance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountBalance = accountBlance;
    }
}
