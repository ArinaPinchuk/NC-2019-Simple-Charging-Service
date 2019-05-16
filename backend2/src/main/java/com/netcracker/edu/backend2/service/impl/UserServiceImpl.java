package com.netcracker.edu.backend2.service.impl;

import com.netcracker.edu.backend2.entities.UsersEntity;
import com.netcracker.edu.backend2.repository.UserRepository;
import com.netcracker.edu.backend2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UsersEntity> findAll() {
        return (List<UsersEntity>) userRepository.findAll();
    }

    @Override
    public UsersEntity findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public UsersEntity save(UsersEntity user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<UsersEntity> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<UsersEntity> findAllByRoleId(int roleId) {
        return userRepository.findAllByRoleByRoleIdRoleId(roleId);
    }


}
