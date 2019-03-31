package test;

import javax.persistence.*;

@Entity
@Table(name = "ewallets", schema = "charging_service", catalog = "")
public class EwalletsEntity {
    private int ewalletId;
    private double balance;

    @Id
    @Column(name = "ewallet_id")
    public int getEwalletId() {
        return ewalletId;
    }

    public void setEwalletId(int ewalletId) {
        this.ewalletId = ewalletId;
    }

    @Basic
    @Column(name = "balance")
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EwalletsEntity that = (EwalletsEntity) o;

        if (ewalletId != that.ewalletId) return false;
        if (Double.compare(that.balance, balance) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = ewalletId;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
