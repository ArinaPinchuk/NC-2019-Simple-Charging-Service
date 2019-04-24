package com.netcracker.edu.backend2.controllers;


import com.netcracker.edu.backend2.entities.RoleEntity;
import com.netcracker.edu.backend2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<RoleEntity> getAllRoles() {
        return roleService.findAll();
    }

    /*@RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }*/
}

