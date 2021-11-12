package com.tradomator.controller;

import com.tradomator.model.CoinIdCard;
import com.tradomator.model.CurrentPrice;
import com.tradomator.model.coingeckoapi.CgeckoApiCoin;
import com.tradomator.model.coingeckoapi.CurrentPriceApi;
import com.tradomator.model.coingeckoapi.ImageApi;
import com.tradomator.model.coingeckoapi.MarketDataApi;
import com.tradomator.service.coingeckoapi.CoingeckoApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

import static  org.hamcrest.MatcherAssert.assertThat;
import static  org.hamcrest.Matchers.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CoinGeckoControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private CoingeckoApiService coingeckoApiService;

    @Test
    void getSingleCoinByIdFromCoingecko_shouldReturnSingleCoinFromCoingeckoApi() {
        //GIVEN
        String url = ("http://localhost:" + port + "/coingecko-api/bitcoin");

        MarketDataApi marketDataApi1 = new MarketDataApi(new CurrentPriceApi(60000.12345f, 45000.54321f));

        LocalDateTime currentDateTime = LocalDateTime.now();

        CgeckoApiCoin cgeckoApiCoin1 = new CgeckoApiCoin();
        cgeckoApiCoin1.setId("bitcoin");
        cgeckoApiCoin1.setSymbol("btc");
        cgeckoApiCoin1.setName("Bitcoin");
        cgeckoApiCoin1.setMarketData(marketDataApi1);
        cgeckoApiCoin1.setImage(new ImageApi("https:/fakeURL"));
        cgeckoApiCoin1.setLastUpdated(currentDateTime);


        when(restTemplate.getForEntity(
                "https://api.coingecko.com/api/v3/coins/bitcoin",
                CgeckoApiCoin.class)

        ).thenReturn(ResponseEntity.ok(cgeckoApiCoin1));


        //WHEN
        ResponseEntity<CoinIdCard> response = testRestTemplate.getForEntity(url, CoinIdCard.class);
        CoinIdCard expected = new CoinIdCard();
        expected.setId("bitcoin");
        expected.setSymbol("btc");
        expected.setName("Bitcoin");
        expected.setCurrentPrice(new CurrentPrice(marketDataApi1.getCurrentPriceApi().getUsd()));
        expected.setImageUrl("https:/fakeURL");
        expected.setLastUpdated(currentDateTime);

        //THEN
        assertThat(response.getBody(), is(expected));
        verify(restTemplate).getForEntity("https://api.coingecko.com/api/v3/coins/bitcoin", CgeckoApiCoin.class);


    }

}