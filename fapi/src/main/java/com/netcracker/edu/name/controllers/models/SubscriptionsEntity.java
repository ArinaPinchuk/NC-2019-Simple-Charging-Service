package com.netcracker.edu.name.controllers.models;

import java.sql.Timestamp;
import java.util.Objects;

public class SubscriptionsEntity {
    private Timestamp date;
    private int subscriptionId;
    private UsersEntity usersByUserId;
    private ProductsEntity productsByProductId;

    public Timestamp getDate() {
        return date;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public ProductsEntity getProductsByProductId() {
        return productsByProductId;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    public void setProductsByProductId(ProductsEntity productsByProductId) {
        this.productsByProductId = productsByProductId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionsEntity that = (SubscriptionsEntity) o;
        return subscriptionId == that.subscriptionId &&
                Objects.equals(date, that.date) &&
                Objects.equals(usersByUserId, that.usersByUserId) &&
                Objects.equals(productsByProductId, that.productsByProductId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, subscriptionId, usersByUserId, productsByProductId);
    }
}
