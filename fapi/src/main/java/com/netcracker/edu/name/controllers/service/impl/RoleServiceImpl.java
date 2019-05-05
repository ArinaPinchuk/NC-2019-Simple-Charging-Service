package com.netcracker.edu.name.controllers.service.impl;

import com.netcracker.edu.name.controllers.models.RoleEntity;
import com.netcracker.edu.name.controllers.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("RoleDetailsService")
public class RoleServiceImpl implements RoleService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    /*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
*/

    @Override
    public List<RoleEntity> findAll() {

        RestTemplate restTemplate = new RestTemplate();
        RoleEntity[] rolesResponse = restTemplate.getForObject(backendServerUrl + "/api/role", RoleEntity[].class);
        return rolesResponse == null ? Collections.emptyList() : Arrays.asList(rolesResponse);
    }
    @Override
    public RoleEntity save(RoleEntity role) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/role", role, RoleEntity.class).getBody();
    }

    /*@Override
    public RoleEntity save(RoleEntity role) {

        *//*user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user", user, User.class).getBody();*//*
        return null;
    }*/

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        return authorities;
    }*/

}
