package com.netcracker.edu.backend2.controllers;

import com.netcracker.edu.backend2.entities.RoleEntity;
import com.netcracker.edu.backend2.entities.SubscriptionsEntity;
import com.netcracker.edu.backend2.entities.UsersEntity;
import com.netcracker.edu.backend2.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subscription")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<SubscriptionsEntity> getAllRoles() {
        return subscriptionService.findAll();
    }

    @RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET)
    public List<SubscriptionsEntity> getSubscriptionsByUserId(@PathVariable(name = "userId") int userId) {
        List<SubscriptionsEntity> subscriptionsEntities = subscriptionService.findSubscriptionsByUserId(userId);
        return subscriptionsEntities;
    }
    @RequestMapping(method = RequestMethod.POST)
    public SubscriptionsEntity saveSubscription(@RequestBody SubscriptionsEntity subscription) {
        return subscriptionService.save(subscription);
    }
}
