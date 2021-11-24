package com.tradomator.controller;

import com.tradomator.model.Wallet;
import com.tradomator.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    private final WalletService walletservice;

    @GetMapping()
    public Wallet getWalletInfo() {
        return walletservice.getLatestWalletDocument();
    }

}
