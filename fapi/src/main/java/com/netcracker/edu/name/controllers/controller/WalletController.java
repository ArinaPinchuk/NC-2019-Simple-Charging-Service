package com.netcracker.edu.name.controllers.controller;

import com.netcracker.edu.name.controllers.models.WalletsEntity;
import com.netcracker.edu.name.controllers.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/wallet")
public class WalletController {
    @Autowired
    WalletService walletService;
    @GetMapping
    public List<WalletsEntity> getAllWallets(){
        return walletService.findAll();
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<WalletsEntity> save(@RequestBody WalletsEntity wallet) {
        if (wallet != null) {
            return ResponseEntity.ok(walletService.save(wallet));
        }
        return null;
    }


}
