package com.netcracker.edu.backend2.service;

import com.netcracker.edu.backend2.entities.UsersEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface UserService {
    List<UsersEntity> findAll();
    UsersEntity findByLogin(String login);
    UsersEntity save(UsersEntity user);
    void delete(long id);
    Page<UsersEntity> findAll(Pageable pageable);
    List<UsersEntity> findAllByRoleId(int roleId);

}
