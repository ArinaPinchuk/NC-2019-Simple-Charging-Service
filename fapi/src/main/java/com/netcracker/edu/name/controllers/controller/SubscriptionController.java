package com.netcracker.edu.name.controllers.controller;

import com.netcracker.edu.name.controllers.models.SubscriptionsEntity;
import com.netcracker.edu.name.controllers.models.UsersEntity;
import com.netcracker.edu.name.controllers.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;
    @GetMapping
    public List<SubscriptionsEntity> getAllSubscriptions(){
        return subscriptionService.findAll();
    }

    @GetMapping("/userId/{userId}")
    public List<SubscriptionsEntity> getUserByLogin(@PathVariable int userId) {
        return subscriptionService.findByUserId(userId);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<SubscriptionsEntity> save(@RequestBody SubscriptionsEntity subscription /*todo server validation*/) {
        if (subscription!= null) {

            return ResponseEntity.ok(subscriptionService.save(subscription));
        }
        return null;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSubscription(@PathVariable String id) {
        subscriptionService.deleteSubscription(Integer.valueOf(id));
    }


}
