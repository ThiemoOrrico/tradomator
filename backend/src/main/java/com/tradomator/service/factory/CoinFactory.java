package com.tradomator.service.factory;

import com.tradomator.model.CoinIdCard;
import com.tradomator.model.CurrentPrice;
import com.tradomator.model.coingeckoapi.GeckoCoinApi;
import org.springframework.stereotype.Service;

@Service
public class CoinFactory {

    public CoinIdCard mapToCoin(GeckoCoinApi geckoCoinApi){
        CurrentPrice currentPriceApi = geckoCoinApi.getMarketData().getCurrentPriceApi();
        return CoinIdCard
                .builder()
                .id(geckoCoinApi.getId())
                .symbol(geckoCoinApi.getSymbol())
                .name(geckoCoinApi.getName())
                .currentPrice(CurrentPrice
                        .builder()

                        .usd(currentPriceApi.getUsd())
                        .build()
                )
                .imageUrl(geckoCoinApi.getImage().getImageUrl())
                .lastUpdated(geckoCoinApi.getLastUpdated())
                .build();
    }

}
