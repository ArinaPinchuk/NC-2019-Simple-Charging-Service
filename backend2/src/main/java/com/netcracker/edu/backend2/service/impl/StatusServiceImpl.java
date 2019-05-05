package com.netcracker.edu.backend2.service.impl;

import com.netcracker.edu.backend2.entities.StatusEntity;
import com.netcracker.edu.backend2.repository.StatusRepository;
import com.netcracker.edu.backend2.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusRepository statusRepository;

    @Override
    public StatusEntity getStatusEntityByStatusId(int id) {
        return statusRepository.getStatusEntityByStatusId(id);
    }
}
