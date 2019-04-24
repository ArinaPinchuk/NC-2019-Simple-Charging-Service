package com.netcracker.edu.backend2.service;

import com.netcracker.edu.backend2.entities.UsersEntity;

import java.util.List;

public interface UserService {
    List<UsersEntity> findAll();
    UsersEntity findByLogin(String login);
    UsersEntity save(UsersEntity user);
    void delete(long id);
}
