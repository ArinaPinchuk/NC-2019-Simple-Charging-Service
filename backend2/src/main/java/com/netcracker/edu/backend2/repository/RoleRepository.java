package com.netcracker.edu.backend2.repository;

import com.netcracker.edu.backend2.entities.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {
    RoleEntity getRoleEntitiesByRoleId(int id);
}