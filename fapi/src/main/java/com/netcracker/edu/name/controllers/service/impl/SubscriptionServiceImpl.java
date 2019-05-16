package com.netcracker.edu.name.controllers.service.impl;

import com.netcracker.edu.name.controllers.models.RoleEntity;
import com.netcracker.edu.name.controllers.models.SubscriptionsEntity;
import com.netcracker.edu.name.controllers.models.UsersEntity;
import com.netcracker.edu.name.controllers.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<SubscriptionsEntity> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        SubscriptionsEntity[] subscriptionsResponse = restTemplate.getForObject(backendServerUrl + "/api/subscription", SubscriptionsEntity[].class);
        return subscriptionsResponse == null ? Collections.emptyList() : Arrays.asList(subscriptionsResponse);
    }

    @Override
    public List<SubscriptionsEntity> findByUserId(int userId) {
        RestTemplate restTemplate = new RestTemplate();
        SubscriptionsEntity[] subscriptionsResponse = restTemplate.getForObject(backendServerUrl+"/api/subscription/userId/"+userId, SubscriptionsEntity[].class);
        return subscriptionsResponse == null ? Collections.emptyList() : Arrays.asList(subscriptionsResponse);
    }

    @Override
    public SubscriptionsEntity save(SubscriptionsEntity subscription) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/subscription", subscription, SubscriptionsEntity.class).getBody();

    }

    @Override
    public void deleteSubscription(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/subscription/" + id);
    }

}
