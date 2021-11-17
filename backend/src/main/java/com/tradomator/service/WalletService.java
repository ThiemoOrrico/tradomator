package com.tradomator.service;

import com.tradomator.model.Wallet;
import com.tradomator.repo.WalletRepo;
import com.tradomator.service.walletmapper.BinanceApiWalletMapper;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class WalletService {

    private final WalletRepo walletRepo;

    public WalletService(WalletRepo walletRepo, BinanceApiWalletMapper binanceApiWalletMapper) {
        this.walletRepo = walletRepo;
    }

    public List<Wallet> getWalletInfo() {
        return walletRepo.findAll();

    }
}

