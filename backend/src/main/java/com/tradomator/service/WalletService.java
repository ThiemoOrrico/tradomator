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

        return walletRepo.findTopByOrderByUpdateTimeDesc()
                .orElseThrow(() -> new NoSuchElementException("Wallet Id is not set or no wallets in DB found!"));
    }
}

