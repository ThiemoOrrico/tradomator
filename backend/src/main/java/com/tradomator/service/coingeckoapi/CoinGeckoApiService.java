package com.tradomator.service.coingeckoapi;

import com.tradomator.model.coingeckoapi.CoingeckoListApi;
import com.tradomator.model.coingeckoapi.GeckoCoinApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class CoinGeckoApiService {

    private final WebClient webClient;

    @Autowired
    public CoinGeckoApiService (WebClient webClient){
        this.webClient = webClient;
    }

    public GeckoCoinApi getCoinInfoByIdFromCoinGecko(String coinId){
        return webClient
                .get()
                .uri("/coins/" + coinId)
                .retrieve()
                .bodyToMono(GeckoCoinApi.class)
                .block(Duration.ofSeconds(3));
    }



}
