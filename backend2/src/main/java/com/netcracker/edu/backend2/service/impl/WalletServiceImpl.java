package com.netcracker.edu.backend2.service.impl;

import com.netcracker.edu.backend2.entities.WalletsEntity;
import com.netcracker.edu.backend2.repository.WalletRepository;
import com.netcracker.edu.backend2.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    WalletRepository walletRepository;

    @Override
    public List<WalletsEntity> findAll() {
        return (List<WalletsEntity>) walletRepository.findAll();
    }

    @Override
    public WalletsEntity save(WalletsEntity wallet) {
        WalletsEntity walletsEntity = walletRepository.save(wallet);
        return walletsEntity;
    }
}
