package com.netcracker.edu.name.controllers.models;

import java.util.Objects;

public class WalletsEntity {
    private Integer walletId;
    private double balance;
    private String cardType;
    private String cardNumber;

    public Integer getWalletId() {
        return walletId;
    }

    public double getBalance() {
        return balance;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
