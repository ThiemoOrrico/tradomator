package com.tradomator.controller;

import com.tradomator.model.Wallet;
import com.tradomator.service.WalletService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    private final WalletService walletservice;

    public WalletController(WalletService walletservice) {
        this.walletservice = walletservice;
    }

    @GetMapping()
    public List<Wallet> getWalletInfo(){
        return walletservice.getWalletInfo();
    }

}
