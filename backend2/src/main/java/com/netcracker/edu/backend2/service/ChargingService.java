package com.netcracker.edu.backend2.service;

import com.netcracker.edu.backend2.entities.SubscriptionsEntity;
import com.netcracker.edu.backend2.entities.UsersEntity;
import com.netcracker.edu.backend2.entities.WalletsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;

@Configuration
@EnableScheduling
public class ChargingService {
    @Autowired
    UserService userService;
    @Autowired
    SubscriptionService subscriptionService;
    @Autowired
    WalletService walletService;

    @Scheduled(fixedDelay = 1000*60*60*24)
    public void chargeMoney() {
        ArrayList<SubscriptionsEntity> subscriptionsEntities=new ArrayList<>(subscriptionService.findAll());
        for(SubscriptionsEntity subscription:subscriptionsEntities)
        {
            onceChargeMoney(subscription);
            subscription.setDays(subscription.getDays()-1);
            if(subscription.getDays()<=0)
            {
                subscriptionService.delete(subscription);
            }
            else subscriptionService.save(subscription);
        }
    }
    public void onceChargeMoney(SubscriptionsEntity subscription) {
        double price = subscription.getProductsByProductId().getPrice();
        UsersEntity user = subscription.getUsersByUserId();
        WalletsEntity wallet =user.getWalletsByWalletId();
        wallet.setBalance(wallet.getBalance()-price);
        walletService.save(wallet);
    }


}
