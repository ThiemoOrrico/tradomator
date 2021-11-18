package com.tradomator.service;

import com.tradomator.model.Wallet;
import com.tradomator.repo.WalletRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class WalletService {

    private final WalletRepo walletRepo;


    public WalletService(WalletRepo walletRepo) {
        this.walletRepo = walletRepo;

    }


    public Wallet getLatestWalletDocument() {
        List<Wallet> all = walletRepo.findAll();

        if(all.isEmpty()){
            throw new NoSuchElementException("No wallets in DB found!");
        }

        Wallet latestWallet = null;
        long max = 0;
        for ( Wallet wallet : all){
            if( wallet.getUpdateTime() > max ){
                max = wallet.getUpdateTime();
                latestWallet = wallet;
            }
        }
        return latestWallet;
    }
}

