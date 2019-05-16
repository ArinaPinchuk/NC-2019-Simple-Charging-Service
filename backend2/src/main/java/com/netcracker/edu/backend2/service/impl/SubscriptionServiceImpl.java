package com.netcracker.edu.backend2.service.impl;

import com.netcracker.edu.backend2.entities.SubscriptionsEntity;
import com.netcracker.edu.backend2.repository.SubscriptionRepository;
import com.netcracker.edu.backend2.service.ChargingService;
import com.netcracker.edu.backend2.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    SubscriptionRepository subscriptionRepository;
    @Autowired
    ChargingService chargingService;
    @Override
    public List<SubscriptionsEntity> findAll() {
        return (List<SubscriptionsEntity>)subscriptionRepository.findAll();
    }

    @Override
    public List<SubscriptionsEntity> findSubscriptionsByUserId(int id) {
        return subscriptionRepository.findSubscriptionsEntitiesByUsersByUserId_UserId(id);
    }

    @Override
    public SubscriptionsEntity save(SubscriptionsEntity subscription) {
        chargingService.onceChargeMoney(subscription);
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void delete(SubscriptionsEntity subscription) {
        subscriptionRepository.delete(subscription);
    }

    @Override
    public void deleteBillingAccount(Integer id) {
        subscriptionRepository.deleteById(id);
    }

}
