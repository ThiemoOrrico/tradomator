package com.tradomator.service;

import com.tradomator.model.Wallet;
import com.tradomator.repo.WalletRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    private final WalletRepo walletRepo;

    public WalletService(WalletRepo walletRepo) {
        this.walletRepo = walletRepo;
    }

    public List<Wallet> getWalletInfo() {
        return walletRepo.findAll();

    }
}

