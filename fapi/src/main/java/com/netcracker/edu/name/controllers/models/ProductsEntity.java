package com.netcracker.edu.name.controllers.models;

import java.util.Arrays;
import java.util.Objects;

public class ProductsEntity {
    private int productId;
    private String name;
    private double price;
    private String shortDescription;
    private String longDescription;
    private String image;
    private UsersEntity usersByCreatorId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return productId == that.productId &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(shortDescription, that.shortDescription) &&
                Objects.equals(longDescription, that.longDescription) &&
                Objects.equals(image, that.image) &&
                Objects.equals(usersByCreatorId, that.usersByCreatorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, price, shortDescription, longDescription, image, usersByCreatorId);
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setUsersByCreatorId(UsersEntity usersByCreatorId) {
        this.usersByCreatorId = usersByCreatorId;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getImage() {
        return image;
    }

    public UsersEntity getUsersByCreatorId() {
        return usersByCreatorId;
    }
}
