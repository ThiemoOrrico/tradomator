package com.tradomator.service.factory;

import com.tradomator.model.CoinIdCard;
import com.tradomator.model.CurrentPrice;
import com.tradomator.model.coingeckoapi.CgeckoApiCoin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoinFactory {

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

/*OLD
    public CoinIdCard mapToCoin(CgeckoCoinApi cgeckoCoinApi){
        CurrentPrice currentPriceApi = cgeckoCoinApi.getMarketData().getCurrentPriceApi();
        return CoinIdCard
                .builder()
                .id(cgeckoCoinApi.getId())
                .symbol(cgeckoCoinApi.getSymbol())
                .name(cgeckoCoinApi.getName())
                .currentPrice(CurrentPrice
                        .builder()

                        .usd(currentPriceApi.getUsd())
                        .build()
                )
                .imageUrl(cgeckoCoinApi.getImage().getImageUrl())
                .lastUpdated(cgeckoCoinApi.getLastUpdated())
                .build();
    }

 */