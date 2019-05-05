package com.netcracker.edu.backend2.repository;

import com.netcracker.edu.backend2.entities.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UsersEntity, Long> {
    UsersEntity findByLogin(String login);

}
