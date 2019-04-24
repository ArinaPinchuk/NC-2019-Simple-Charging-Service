package com.netcracker.edu.backend2.controllers;

import com.netcracker.edu.backend2.entities.UsersEntity;
import com.netcracker.edu.backend2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UsersEntity> getAllUsers() {
        return userService.findAll();
    }
}