package com.netcracker.edu.backend2.service;

import com.netcracker.edu.backend2.entities.RoleEntity;

import java.util.List;

public interface RoleService {
    List<RoleEntity> findAll();
    RoleEntity save(RoleEntity user);
    void delete(int id);
    RoleEntity getRoleEntitiesByRoleId(int id);


}
