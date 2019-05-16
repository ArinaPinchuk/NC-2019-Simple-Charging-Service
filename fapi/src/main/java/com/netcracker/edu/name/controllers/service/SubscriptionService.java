package com.netcracker.edu.name.controllers.service;

import com.netcracker.edu.name.controllers.models.SubscriptionsEntity;

import java.util.List;

public interface SubscriptionService {
    List<SubscriptionsEntity> findAll();
    List<SubscriptionsEntity> findByUserId(int userId);
    SubscriptionsEntity save(SubscriptionsEntity subscription);
    void deleteSubscription(Integer id);

}
