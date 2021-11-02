package com.tradomator.service;


import com.tradomator.model.CoinIdCard;
import com.tradomator.model.coingeckoapi.GeckoCoinApi;
import com.tradomator.service.coingeckoapi.CoinGeckoApiService;
import com.tradomator.service.factory.CoinFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {

    private final CoinGeckoApiService coinGeckoApiService;
    private final CoinFactory coinFactory;

    @Autowired
    public CoinService(CoinGeckoApiService coinGeckoApiService, CoinFactory coinFactory){
        this.coinGeckoApiService = coinGeckoApiService;
        this.coinFactory = coinFactory;
    }

    public CoinIdCard getCoinDataById(String coinId){
        GeckoCoinApi geckoCoinApi = coinGeckoApiService.getCoinInfoByIdFromCoinGecko(coinId);
        return coinFactory.mapToCoin(geckoCoinApi);
    }

    public List<CoinIdCard> getStandardCoins(){
        CoinIdCard bitcoinData = coinFactory.mapToCoin(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("bitcoin"));
        CoinIdCard etheriumData = coinFactory.mapToCoin(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("ethereum"));
        CoinIdCard shibainuData = coinFactory.mapToCoin(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("shiba-inu"));
        CoinIdCard vergeData = coinFactory.mapToCoin(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("verge"));
        CoinIdCard iotexData = coinFactory.mapToCoin(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("iotex"));
        CoinIdCard troyData = coinFactory.mapToCoin(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("troy"));
        CoinIdCard linaData = coinFactory.mapToCoin(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("lina"));
        CoinIdCard rippleData = coinFactory.mapToCoin(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("ripple"));
        CoinIdCard iotaData = coinFactory.mapToCoin(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("iota"));

        return List.of(bitcoinData, etheriumData, shibainuData, vergeData, iotexData, troyData, linaData, rippleData, iotaData);
    }
}
