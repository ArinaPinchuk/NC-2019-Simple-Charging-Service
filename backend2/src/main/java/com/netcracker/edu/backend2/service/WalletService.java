package com.netcracker.edu.backend2.service;


import com.netcracker.edu.backend2.entities.WalletsEntity;

import java.util.List;

public interface WalletService {
    List<WalletsEntity> findAll();
    WalletsEntity save(WalletsEntity wallet);
}
