package com.netcracker.edu.backend2.repository;

import com.netcracker.edu.backend2.entities.UsersEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UsersEntity, Long> {
    UsersEntity findByLogin(String login);
    List<UsersEntity> findAllByRoleByRoleIdRoleId(int roleId);
//    Iterable<UsersEntity>findAll(Sort sort);
    //Page <UsersEntity> findAll(Pageable pageable);


}
