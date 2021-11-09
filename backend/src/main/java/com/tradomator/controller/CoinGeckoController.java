package com.tradomator.controller;

import com.tradomator.model.CoinIdCard;
import com.tradomator.service.CoinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coingecko-api")
public class CoinGeckoController {

    private final CoinService coinService;

    @Autowired
    public CoinGeckoController(CoinService coinService) {
        this.coinService = coinService;
    }


    @GetMapping
    public List<CoinIdCard> getAllCoinsFromCoingeckoApi(){
        return coinService.getCoinDataById();
    }

    @GetMapping("{coinId}")
    public List<CoinIdCard> getCoinSymbolWithPrice(@PathVariable String coinId){
        return coinService.getCoinDataById();
    }


}
