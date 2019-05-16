package com.netcracker.edu.name.controllers.service.impl;

import com.netcracker.edu.name.controllers.models.SubscriptionsEntity;
import com.netcracker.edu.name.controllers.models.UsersEntity;
import com.netcracker.edu.name.controllers.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;


import java.util.*;

@Service("customUserDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {
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

    @Override
    public UsersEntity registerUser(UsersEntity user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user/register", user, UsersEntity.class).getBody();
    }

    @Override
    public List<UsersEntity> findByRoleId(int roleId) {
        RestTemplate restTemplate = new RestTemplate();
        UsersEntity[] usersResponse = restTemplate.getForObject(backendServerUrl+"/api/user/role/"+roleId, UsersEntity[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UsersEntity user = findByLogin(s);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getAuthority(user));

    }
    private Set<SimpleGrantedAuthority> getAuthority(UsersEntity user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRoleByRoleId()));
        return authorities;
    }
}
