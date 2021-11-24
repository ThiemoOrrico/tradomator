package com.tradomator.mapper;

import com.tradomator.model.CoinIdCard;
import com.tradomator.model.CurrentPrice;
import com.tradomator.model.dto.coingeckoapi.CgeckoApiCoin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoingeckoMapper {

    public List<CoinIdCard> mapToCoins(List<CgeckoApiCoin> cgeckoApiCoins) {
        List<CoinIdCard> coinIdCards = new ArrayList<>();

        for (CgeckoApiCoin cgeckoApiCoin : cgeckoApiCoins) {

            coinIdCards.add(mapToCoin(cgeckoApiCoin));

        }
        return coinIdCards;

    }

    public CoinIdCard mapToCoin(CgeckoApiCoin cgeckoApiCoin){
       return new CoinIdCard(
                cgeckoApiCoin.getId(),
                cgeckoApiCoin.getSymbol(),
                cgeckoApiCoin.getName(),
                new CurrentPrice(cgeckoApiCoin.getMarketData().getCurrentPriceApi().getUsd()),
                cgeckoApiCoin.getImage().getImageUrl(),
                cgeckoApiCoin.getLastUpdated()
        );

    }

}

