package com.tradomator.service;

import com.tradomator.model.CoinIdCard;
import com.tradomator.model.coingeckoapi.CgeckoApiCoin;
import com.tradomator.service.coingeckoapi.CoingeckoApiService;
import com.tradomator.service.mapperapi.CoingeckoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {

    private final CoingeckoApiService coinGeckoApiService;
    private final CoingeckoMapper coingeckoMapper;


    public CoinService(CoingeckoApiService coinGeckoApiService, CoingeckoMapper coingeckoMapper) {
        this.coinGeckoApiService = coinGeckoApiService;
        this.coingeckoMapper = coingeckoMapper;
    }

    public List<CoinIdCard> getCoinDataById() {
        CgeckoApiCoin[] cgeckoApiCoins = coinGeckoApiService.getCgeckoCoinInfoById();
        return coingeckoMapper.mapToCoin(cgeckoApiCoins);
    }


}

