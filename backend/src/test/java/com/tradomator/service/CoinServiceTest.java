package com.tradomator.service;

import com.tradomator.model.CoinIdCard;
import com.tradomator.model.CurrentPrice;
import com.tradomator.model.coingeckoapi.CgeckoApiCoin;
import com.tradomator.model.coingeckoapi.CurrentPriceApi;
import com.tradomator.model.coingeckoapi.ImageApi;
import com.tradomator.model.coingeckoapi.MarketDataApi;
import com.tradomator.service.coingeckoapi.CoingeckoApiService;
import com.tradomator.service.mapperapi.CoingeckoMapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.hamcrest.Matchers;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CoinServiceTest {

    private final CoingeckoApiService coingeckoApiService = mock(CoingeckoApiService.class);
    private final CoingeckoMapper coingeckoMapper = mock(CoingeckoMapper.class);

    private final CoinService coinService = new CoinService(coingeckoApiService, coingeckoMapper);

    @Test
    void getCoinDataById_shouldReturn() {
        //GIVEN
        String coinId = "someBitcoinId";

        MarketDataApi marketDataApi1 = new MarketDataApi(new CurrentPriceApi(60000.12345f, 45000.54321f));

        LocalDateTime currentDateTime = LocalDateTime.now();

        CgeckoApiCoin cgeckoApiCoin1 = new CgeckoApiCoin();
        cgeckoApiCoin1.setId("bitcoin");
        cgeckoApiCoin1.setSymbol("btc");
        cgeckoApiCoin1.setName("Bitcoin");
        cgeckoApiCoin1.setMarketData(marketDataApi1);
        cgeckoApiCoin1.setImage(new ImageApi("https:/fakeURL"));
        cgeckoApiCoin1.setLastUpdated(currentDateTime);

        when(coingeckoApiService.getCgeckoCoinById("someBitcoinId")).thenReturn(cgeckoApiCoin1);

        CurrentPrice currentPrice1 = new CurrentPrice((float) 60000.12345);

        CoinIdCard coinIdCard1 = new CoinIdCard();
        coinIdCard1.setId("bitcoin");
        coinIdCard1.setSymbol("btc");
        coinIdCard1.setName("Bitcoin");
        coinIdCard1.setCurrentPrice(currentPrice1);
        coinIdCard1.setImageUrl("https:/fakeURL");
        coinIdCard1.setLastUpdated(currentDateTime);

        when(coingeckoMapper.mapToCoin(cgeckoApiCoin1)).thenReturn(coinIdCard1);

        //WHEN
        CoinIdCard actual = coinService.getCoinDataById(coinId);

        //THEN
        assertThat(actual, is(coinIdCard1));
        verify(coingeckoApiService).getCgeckoCoinById(coinId);
        verify(coingeckoMapper).mapToCoin(cgeckoApiCoin1);
    }

    @Test
    void getAllCoinData_shouldreturnListOfCoins() {
        //GIVEN
        MarketDataApi marketDataApi1 = new MarketDataApi(new CurrentPriceApi(60000.12345f, 45000.54321f));

        LocalDateTime currentDateTime = LocalDateTime.now();

        CgeckoApiCoin cgeckoApiCoin1 = new CgeckoApiCoin();
        cgeckoApiCoin1.setId("bitcoin");
        cgeckoApiCoin1.setSymbol("btc");
        cgeckoApiCoin1.setName("Bitcoin");
        cgeckoApiCoin1.setMarketData(marketDataApi1);
        cgeckoApiCoin1.setImage(new ImageApi("https:/fakeURL"));
        cgeckoApiCoin1.setLastUpdated(currentDateTime);

        CgeckoApiCoin cgeckoApiCoin2 = new CgeckoApiCoin();
        cgeckoApiCoin2.setId("ethereum");
        cgeckoApiCoin2.setSymbol("etc");
        cgeckoApiCoin2.setName("Ethereum");
        cgeckoApiCoin2.setMarketData(marketDataApi1);
        cgeckoApiCoin2.setImage(new ImageApi("https:/fakeURLEthereum"));
        cgeckoApiCoin2.setLastUpdated(currentDateTime);


        when(coingeckoApiService.getAllCgeckoCoinInfo()).thenReturn( new CgeckoApiCoin[]{cgeckoApiCoin1, cgeckoApiCoin2});


        CurrentPrice currentPrice1 = new CurrentPrice((float) 60000.12345);

        CoinIdCard coinIdCard1 = new CoinIdCard();
        coinIdCard1.setId("bitcoin");
        coinIdCard1.setSymbol("btc");
        coinIdCard1.setName("Bitcoin");
        coinIdCard1.setCurrentPrice(currentPrice1);
        coinIdCard1.setImageUrl("https:/fakeURL");
        coinIdCard1.setLastUpdated(currentDateTime);

        CurrentPrice currentPrice2 = new CurrentPrice((float) 4325.543);

        CoinIdCard coinIdCard2 = new CoinIdCard();
        coinIdCard1.setId("ethereum");
        coinIdCard1.setSymbol("eth");
        coinIdCard1.setName("Ethereum");
        coinIdCard1.setCurrentPrice(currentPrice2);
        coinIdCard1.setImageUrl("https:/fakeURL");
        coinIdCard1.setLastUpdated(currentDateTime);


        when(coingeckoMapper.mapToCoins(List.of(cgeckoApiCoin1, cgeckoApiCoin2))).thenReturn(
                List.of(coinIdCard1, coinIdCard2));

        //WHEN
        List<CoinIdCard> actual = coinService.getAllCoinData();

        //THEN
        assertThat(actual, is(List.of(coinIdCard1, coinIdCard2)));
        verify(coingeckoApiService).getAllCgeckoCoinInfo();
        verify(coingeckoMapper).mapToCoins(List.of(cgeckoApiCoin1, cgeckoApiCoin2));

    }


}