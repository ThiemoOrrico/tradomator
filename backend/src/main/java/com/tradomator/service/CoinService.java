package com.tradomator.service;


import com.tradomator.model.CoinIdCard;
import com.tradomator.model.coingeckoapi.CgeckoApiCoin;
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

    public List<CoinIdCard> getCoinDataById(){
        CgeckoApiCoin[] cgeckoApiCoins = coinGeckoApiService.getCgeckoCoinInfoById();
        return coinFactory.mapToCoin(cgeckoApiCoins);
    }

    public List<CoinIdCard> getStandardCoins(){
        CoinIdCard bitcoinData = coinFactory.mapToCoin(coinGeckoApiService.getCgeckoCoinInfoById("bitcoin"));
        CoinIdCard etheriumData = coinFactory.mapToCoin(coinGeckoApiService.getCgeckoCoinInfoById("ethereum"));
        CoinIdCard shibainuData = coinFactory.mapToCoin(coinGeckoApiService.getCgeckoCoinInfoById("shiba-inu"));
        CoinIdCard vergeData = coinFactory.mapToCoin(coinGeckoApiService.getCgeckoCoinInfoById("verge"));
        CoinIdCard iotexData = coinFactory.mapToCoin(coinGeckoApiService.getCgeckoCoinInfoById("iotex"));
        CoinIdCard troyData = coinFactory.mapToCoin(coinGeckoApiService.getCgeckoCoinInfoById("troy"));
        CoinIdCard linaData = coinFactory.mapToCoin(coinGeckoApiService.getCgeckoCoinInfoById("lina"));
        CoinIdCard rippleData = coinFactory.mapToCoin(coinGeckoApiService.getCgeckoCoinInfoById("ripple"));
        CoinIdCard iotaData = coinFactory.mapToCoin(coinGeckoApiService.getCgeckoCoinInfoById("iota"));

        return List.of(bitcoinData, etheriumData, shibainuData, vergeData, iotexData, troyData, linaData, rippleData, iotaData);
    }
}
