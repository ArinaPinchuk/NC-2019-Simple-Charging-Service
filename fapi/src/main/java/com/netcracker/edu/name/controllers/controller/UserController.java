package com.netcracker.edu.name.controllers.controller;

import com.netcracker.edu.name.controllers.models.SubscriptionsEntity;
import com.netcracker.edu.name.controllers.models.UsersEntity;
import com.netcracker.edu.name.controllers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //???@PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<UsersEntity> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/login/{login}")
    public UsersEntity getUserByLogin(@PathVariable String login) {
        return userService.findByLogin(login);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UsersEntity> save(@RequestBody UsersEntity user /*todo server validation*/) {
        if (user != null) {
           /* user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));*/

            return ResponseEntity.ok(userService.save(user));
        }
        return null;
    }
    @RequestMapping(value = "/wallet", method = RequestMethod.POST)
    public ResponseEntity<UsersEntity> addWallet(@RequestBody UsersEntity user ) {
        if (user != null) {

            return ResponseEntity.ok(userService.addWallet(user));
        }
        return null;
    }
    @RequestMapping(value = "/block", method = RequestMethod.POST)
    public ResponseEntity<UsersEntity> blockUser(@RequestBody UsersEntity user) {
        if (user != null) {

            return ResponseEntity.ok(userService.blockUser(user));
        }
        return null;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UsersEntity> registerUser(@RequestBody UsersEntity user) {
        if (user != null) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return ResponseEntity.ok(userService.registerUser(user));
        }
        return null;
    }
    @GetMapping("/role/{roleId}")
    public List<UsersEntity> getUserByLogin(@PathVariable int roleId) {
        return userService.findByRoleId(roleId);
    }


}

