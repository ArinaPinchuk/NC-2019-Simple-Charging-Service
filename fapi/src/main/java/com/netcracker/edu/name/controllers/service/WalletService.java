package com.netcracker.edu.name.controllers.service;

import com.netcracker.edu.name.controllers.models.WalletsEntity;

import java.util.List;

public interface WalletService {
    WalletsEntity save(WalletsEntity wallet);
    List<WalletsEntity> findAll();
}
