package com.netcracker.edu.name.controllers.controller;

import com.netcracker.edu.name.controllers.models.RoleEntity;
import com.netcracker.edu.name.controllers.models.UsersEntity;
import com.netcracker.edu.name.controllers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

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

            return ResponseEntity.ok(userService.save(user));
        }
        return null;
    }
    @RequestMapping(value = "/wallet", method = RequestMethod.POST)
    public ResponseEntity<UsersEntity> addWallet(@RequestBody UsersEntity user /*todo server validation*/) {
        if (user != null) {

            return ResponseEntity.ok(userService.addWallet(user));
        }
        return null;
    }
    @RequestMapping(value = "/block", method = RequestMethod.POST)
    public ResponseEntity<UsersEntity> blockUser(@RequestBody UsersEntity user /*todo server validation*/) {
        if (user != null) {

            return ResponseEntity.ok(userService.blockUser(user));
        }
        return null;
    }


}

