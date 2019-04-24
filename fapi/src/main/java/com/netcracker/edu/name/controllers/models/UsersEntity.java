package com.netcracker.edu.name.controllers.models;

import java.util.Objects;

public class UsersEntity {
    private int userId;
    private String firstName;
    private String secondName;
    private String email;
    private String login;
    private String password;
    private StatusEntity statusByStatusId;
    private WalletsEntity walletsByWalletId;
    private RoleEntity roleByRoleId;

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public StatusEntity getStatusByStatusId() {
        return statusByStatusId;
    }

    public WalletsEntity getWalletsByWalletId() {
        return walletsByWalletId;
    }

    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatusByStatusId(StatusEntity statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }

    public void setWalletsByWalletId(WalletsEntity walletsByWalletId) {
        this.walletsByWalletId = walletsByWalletId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return userId == that.userId &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(secondName, that.secondName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(statusByStatusId, that.statusByStatusId) &&
                Objects.equals(walletsByWalletId, that.walletsByWalletId) &&
                Objects.equals(roleByRoleId, that.roleByRoleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, secondName, email, login, password, statusByStatusId, walletsByWalletId, roleByRoleId);
    }
}
