package com.netcracker.edu.backend2.repository;

import com.netcracker.edu.backend2.entities.SubscriptionsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriptionRepository extends CrudRepository<SubscriptionsEntity, Integer> {
    List<SubscriptionsEntity> findSubscriptionsEntitiesByUsersByUserId_UserId(int id);
}

