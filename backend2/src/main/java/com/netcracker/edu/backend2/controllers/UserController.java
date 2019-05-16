package com.netcracker.edu.backend2.controllers;

import com.netcracker.edu.backend2.entities.UsersEntity;
import com.netcracker.edu.backend2.service.RoleService;
import com.netcracker.edu.backend2.service.StatusService;
import com.netcracker.edu.backend2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
    @Autowired
    private StatusService statusService;

    private static final int active=1;
    private static final int blocked = 2;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<UsersEntity> page(@RequestParam(defaultValue = "0")int page) {

        PageRequest request=new PageRequest(page,2);
        return userService.findAll( request);
    }

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public UsersEntity getUserByLogin(@PathVariable(name = "login") String login) {
        UsersEntity user = userService.findByLogin(login);
        return user;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UsersEntity> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UsersEntity saveUser(@RequestBody UsersEntity user) {
        user.setStatusByStatusId(statusService.getStatusEntityByStatusId(blocked));
        return userService.save(user);
    }

    @RequestMapping(value = "/wallet", method = RequestMethod.POST)
    public UsersEntity addWallet(@RequestBody UsersEntity user) {
        user.setStatusByStatusId(statusService.getStatusEntityByStatusId(active));
        return userService.save(user);
    }
    @RequestMapping(value = "/block", method = RequestMethod.POST)
    public UsersEntity blockUser(@RequestBody UsersEntity user) {
        user.setStatusByStatusId(statusService.getStatusEntityByStatusId(blocked));
        return userService.save(user);
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UsersEntity registerUser(@RequestBody UsersEntity user) {
        user.setStatusByStatusId(statusService.getStatusEntityByStatusId(blocked));
        return userService.save(user);
    }
    @RequestMapping(value = "role/{roleId}", method = RequestMethod.GET)
    public List<UsersEntity> getUsersByRoleId(@PathVariable(name = "roleId") int roleId) {
        List<UsersEntity> users=userService.findAllByRoleId(roleId);
        return users;
    }



}