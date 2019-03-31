package test;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "subscriptions", schema = "charging_service", catalog = "")
@IdClass(SubscriptionsEntityPK.class)
public class SubscriptionsEntity {
    private int userId;
    private int serviceId;
    private Timestamp date;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "service_id")
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubscriptionsEntity that = (SubscriptionsEntity) o;

        if (userId != that.userId) return false;
        if (serviceId != that.serviceId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + serviceId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
