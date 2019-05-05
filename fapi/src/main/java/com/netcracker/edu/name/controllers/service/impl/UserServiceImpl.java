package com.netcracker.edu.name.controllers.service.impl;

import com.netcracker.edu.name.controllers.models.UsersEntity;
import com.netcracker.edu.name.controllers.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service("customUserDetailsService")
public class UserServiceImpl implements UserService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public UsersEntity findByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        UsersEntity user = restTemplate.getForObject(backendServerUrl+"/api/user/login/"+login, UsersEntity.class);
        return user;
    }

    @Override
    public List<UsersEntity> findAll() {
        RestTemplate restTemplate=new RestTemplate();
        UsersEntity[] users=restTemplate.getForObject(backendServerUrl+"/api/user", UsersEntity[].class);
        return users==null ? Collections.emptyList():Arrays.asList(users);
    }

    @Override
    public UsersEntity save(UsersEntity user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user", user, UsersEntity.class).getBody();
    }
    @Override
    public UsersEntity addWallet(UsersEntity user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user/wallet", user, UsersEntity.class).getBody();
    }
    @Override
    public UsersEntity blockUser(UsersEntity user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user/block", user, UsersEntity.class).getBody();
    }

//нужно подключить security
}
