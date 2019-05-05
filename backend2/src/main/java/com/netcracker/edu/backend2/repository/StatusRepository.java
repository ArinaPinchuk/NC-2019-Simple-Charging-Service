package com.netcracker.edu.backend2.repository;

import com.netcracker.edu.backend2.entities.StatusEntity;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<StatusEntity, Integer> {
    StatusEntity getStatusEntityByStatusId(int id);
}
