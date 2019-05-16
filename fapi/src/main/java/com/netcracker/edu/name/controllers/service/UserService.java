package com.netcracker.edu.name.controllers.service;

import com.netcracker.edu.name.controllers.models.UsersEntity;

import java.util.List;

public interface UserService {
    UsersEntity findByLogin(String login);
    List<UsersEntity> findAll();
    UsersEntity save(UsersEntity user);
    UsersEntity addWallet(UsersEntity user);
    UsersEntity blockUser(UsersEntity user);
    UsersEntity registerUser(UsersEntity user);
    List<UsersEntity> findByRoleId(int roleId);

}
