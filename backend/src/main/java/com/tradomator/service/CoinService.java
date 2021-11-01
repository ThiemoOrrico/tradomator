package com.tradomator.service;


import com.tradomator.model.CoinIdCard;
import com.tradomator.model.ListofCoingecko;
import com.tradomator.model.coingeckoapi.CoingeckoListApi;
import com.tradomator.model.coingeckoapi.GeckoCoinApi;
import com.tradomator.service.coingeckoapi.CoinGeckoApiListService;
import com.tradomator.service.coingeckoapi.CoinGeckoApiService;
import com.tradomator.service.factory.CoinFactory;
import com.tradomator.service.factory.CoinSymbolFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {

    private final CoinGeckoApiService coinGeckoApiService;
    private final CoinFactory coinFactory;
    private final CoinSymbolFactory coinSymbolFactory;

    @Autowired
    public CoinService(CoinGeckoApiService coinGeckoApiService, CoinFactory coinFactory, CoinSymbolFactory coinSymbolFactory){
        this.coinGeckoApiService = coinGeckoApiService;
        this.coinFactory = coinFactory;
        this.coinSymbolFactory = coinSymbolFactory;
    }

    public CoinIdCard getCoinDataById(String coinId){
        GeckoCoinApi geckoCoinApi = coinGeckoApiService.getCoinInfoByIdFromCoinGecko(coinId);
        return coinFactory.mapToCoin(geckoCoinApi);
    }

    public List<CoinIdCard> getStandardCoins(){
        CoinIdCard bitcoinData = coinFactory.mapToCoin(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("bitcoin"));
        CoinIdCard etheriumData = coinFactory.mapToCoin(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("ethereum"));
        return List.of(bitcoinData, etheriumData);
    }
}
