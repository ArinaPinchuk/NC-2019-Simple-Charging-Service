package com.netcracker.edu.backend2.controllers;

import com.netcracker.edu.backend2.entities.WalletsEntity;
import com.netcracker.edu.backend2.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/wallet")
public class WalletController {
    @Autowired
    WalletService walletService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<WalletsEntity> getAllWallets() {
        return walletService.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public WalletsEntity save(@RequestBody WalletsEntity wallet)
    {
        return  walletService.save(wallet);
    }

}
