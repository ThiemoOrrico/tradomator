package com.tradomator.service.mapperapi;

import com.tradomator.model.CoinIdCard;
import com.tradomator.model.coingeckoapi.CgeckoApiCoin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoingeckoMapper {

    public List<CoinIdCard> mapToCoin(CgeckoApiCoin[] cgeckoApiCoins){
        List<CoinIdCard> coinIdCards = new ArrayList<>();

        for (CgeckoApiCoin cgeckoApiCoin : cgeckoApiCoins) {

            CoinIdCard coinIdCard = new CoinIdCard(
                    cgeckoApiCoin.getId(),
                    cgeckoApiCoin.getSymbol(),
                    cgeckoApiCoin.getName(),
                    cgeckoApiCoin.getMarketData().getCurrentPriceApi(),
                    cgeckoApiCoin.getImage().getImageUrl(),
                    cgeckoApiCoin.getLastUpdated()
            );

            coinIdCards.add(coinIdCard);

        }

        return coinIdCards;

        }
    }

