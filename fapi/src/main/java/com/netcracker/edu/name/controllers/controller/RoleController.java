package com.netcracker.edu.name.controllers.controller;

import com.netcracker.edu.name.controllers.models.RoleEntity;
import com.netcracker.edu.name.controllers.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleEntity> getAllRoles(){
        return roleService.findAll();
    }


}