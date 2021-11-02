package com.tradomator.service.coingeckoapi;

import com.tradomator.model.coingeckoapi.GeckoCoinApi;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CoinGeckoApiServiceTest {

    @Test
    void getCoinInfoByIdFromCoinGecko() {

        //GIVEN
        WebTestClient webTestClient = WebTestClient
            .bindToServer()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .build();


        final String coinId = "bitcoin";

        return webTestClient
                .get()
                .uri("/coins/" + coinId)
                .attributes()
                .bodyToMono(GeckoCoinApi.class)
                .block(Duration.ofSeconds(3));
    }






    //WHEN

        //THEN

    }
}