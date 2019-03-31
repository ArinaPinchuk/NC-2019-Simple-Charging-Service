package test;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "products", schema = "charging_service", catalog = "")
public class ProductsEntity {
    private int serviceId;
    private String name;
    private double price;
    private String shortDescription;
    private String longDescription;
    private byte[] image;

    @Id
    @Column(name = "service_id")
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "short_description")
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Basic
    @Column(name = "long_description")
    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (serviceId != that.serviceId) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (shortDescription != null ? !shortDescription.equals(that.shortDescription) : that.shortDescription != null)
            return false;
        if (longDescription != null ? !longDescription.equals(that.longDescription) : that.longDescription != null)
            return false;
        if (!Arrays.equals(image, that.image)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = serviceId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
        result = 31 * result + (longDescription != null ? longDescription.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
