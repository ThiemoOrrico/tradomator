package com.tradomator.service.factory;

import com.tradomator.model.CoinIdCard;
import com.tradomator.model.CurrentAvgPrice;
import com.tradomator.model.coinGeckoApi.GeckoCoinApi;
import org.springframework.stereotype.Service;

@Service
public class CoinFactory {

    public CoinIdCard mapToCoin(GeckoCoinApi geckoCoinApi){
        CurrentAvgPrice currentAvgPriceApi = geckoCoinApi.getMarketData().getCurrentPriceApi();
        return CoinIdCard
                .builder()
                .id(geckoCoinApi.getId())
                .symbol(geckoCoinApi.getSymbol())
                .name(geckoCoinApi.getName())
                .currentAvgPrice(CurrentAvgPrice
                        .builder()

                        .usd(currentAvgPriceApi.getUsd())
                        .build()
                )
                .imageUrl(geckoCoinApi.getImage().getImageUrl())
                .lastUpdated(geckoCoinApi.getLastUpdated())
                .build();
    }

}
