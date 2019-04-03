package com.netcracker.edu.backend2.controllers;


import com.netcracker.edu.backend2.entities.RoleEntity;
import com.netcracker.edu.backend2.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/test")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value="")
    public Iterable<RoleEntity> getSimpleString() {
        return roleRepository.findAll();
    }
}
