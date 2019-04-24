package com.netcracker.edu.name.controllers.models;

import java.util.Objects;

public class StatusEntity {
    private int statusId;
    private String statusName;

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getStatusId() {
        return statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusEntity that = (StatusEntity) o;
        return statusId == that.statusId &&
                statusName.equals(that.statusName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, statusName);
    }
}
