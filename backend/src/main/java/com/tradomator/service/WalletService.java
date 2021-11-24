package com.tradomator.service;

import com.tradomator.model.Wallet;
import com.tradomator.repo.WalletRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepo walletRepo;

    public Wallet getLatestWalletDocument() {
        Wallet latestWallet = walletRepo.findTopByOrderByUpdateTimeDesc();

        if (latestWallet.getId().isEmpty()) {
            throw new NoSuchElementException("Wallet Id is not set or no wallets in DB found!");
        } else {
            return latestWallet;
        }
    }
}

