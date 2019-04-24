package com.netcracker.edu.name.controllers.service;

import com.netcracker.edu.name.controllers.models.RoleEntity;

import java.util.List;
public interface RoleService {
    List<RoleEntity> findAll();
    RoleEntity save(RoleEntity role);

}
