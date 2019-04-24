package com.netcracker.edu.backend2.service.impl;

import com.netcracker.edu.backend2.entities.RoleEntity;
import com.netcracker.edu.backend2.repository.RoleRepository;
import com.netcracker.edu.backend2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<RoleEntity> findAll() {
        return (List<RoleEntity>) roleRepository.findAll();
    }

    @Override
    public RoleEntity save(RoleEntity role) {
        return roleRepository.save(role);
    }

    @Override
    public void delete(long id) {
        roleRepository.deleteById(id);
    }
}
