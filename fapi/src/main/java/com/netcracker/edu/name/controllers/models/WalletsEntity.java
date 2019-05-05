package com.netcracker.edu.name.controllers.models;

import java.util.Objects;

public class WalletsEntity {
    private Integer walletId;
    private double balance;

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


}
