package com.netcracker.edu.name.controllers.models;

import java.util.Objects;

public class WalletsEntity {
    private int walletId;
    private double balance;

    public int getWalletId() {
        return walletId;
    }

    public double getBalance() {
        return balance;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletsEntity that = (WalletsEntity) o;
        return walletId == that.walletId &&
                Double.compare(that.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(walletId, balance);
    }
}
