package com.netcracker.edu.backend2.service;

import com.netcracker.edu.backend2.entities.SubscriptionsEntity;

import java.util.List;

public interface SubscriptionService{
    List<SubscriptionsEntity> findAll();
    List<SubscriptionsEntity> findSubscriptionsByUserId(int id);
    SubscriptionsEntity save(SubscriptionsEntity subscription);

}
