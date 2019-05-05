package com.netcracker.edu.name.controllers.service.impl;

import com.netcracker.edu.name.controllers.models.UsersEntity;
import com.netcracker.edu.name.controllers.models.WalletsEntity;
import com.netcracker.edu.name.controllers.service.WalletService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {
    @Value("${backend.server.url}")
    private String backendServerUrl;
    @Override
    public WalletsEntity save(WalletsEntity wallet) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/wallet", wallet, WalletsEntity.class).getBody();
    }

    @Override
    public List<WalletsEntity> findAll() {
        RestTemplate restTemplate=new RestTemplate();
        WalletsEntity[] wallets=restTemplate.getForObject(backendServerUrl+"/api/wallet", WalletsEntity[].class);
        return wallets==null ? Collections.emptyList(): Arrays.asList(wallets);
    }
}
