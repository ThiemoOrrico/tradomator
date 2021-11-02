package com.tradomator.service;

import com.tradomator.model.CoinIdCard;
import com.tradomator.model.CurrentAvgPrice;
import com.tradomator.model.coingeckoapi.GeckoCoinApi;
import com.tradomator.model.coingeckoapi.ImageApi;
import com.tradomator.model.coingeckoapi.MarketDataApi;
import com.tradomator.service.coingeckoapi.CoinGeckoApiService;
import com.tradomator.service.factory.CoinFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

class CoinServiceTest {

    private GeckoCoinApi getMockedGeckoCoinApi(){
        return GeckoCoinApi.builder()
                .id("binance-testcoin")
                .name("BinanceTest")
                .image(ImageApi
                        .builder()
                        .imageUrl("url-to-image")
                        .build()
                )
                .marketData(
                        MarketDataApi.builder()
                                .currentPriceApi(CurrentAvgPrice.builder()
                                        .usd(60000)
                                        .build()
                                )
                                .build())
                .lastUpdated(LocalDateTime.of(2021, 11, 2, 18, 15))
                .build();

    }

    private CoinIdCard getMockedCoin() {
        return CoinIdCard.builder()
                .id("binance-testcoin")
                .name("BinanceTest")
                .imageUrl("url-to-image")
                .currentAvgPrice(CurrentAvgPrice.builder()
                        .usd(60000)
                        .build())
                .lastUpdated(LocalDateTime.of(2021, 11, 2, 18, 15))
                .build();
    }

    @Test
    void getCoinDataByIdTest() {
        //GIVEN
        GeckoCoinApi testgeckoCoinApi = getMockedGeckoCoinApi();
        CoinIdCard testcoinIdCard = getMockedCoin();

        CoinGeckoApiService coinGeckoApiService = mock(CoinGeckoApiService.class);
        when(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("binance-testcoin")).thenReturn(testgeckoCoinApi);

        CoinFactory coinFactory = mock(CoinFactory.class);
        when(coinFactory.mapToCoin(testgeckoCoinApi)).thenReturn(testcoinIdCard);

        CoinService coinService = new CoinService(coinGeckoApiService, coinFactory);

        //WHEN
        CoinIdCard actual = coinService.getCoinDataById("binance-testcoin");

        //THEN
        assertThat(actual, is(testcoinIdCard));
        verify(coinGeckoApiService).getCoinInfoByIdFromCoinGecko("binance-testcoin");
        verify(coinFactory).mapToCoin(testgeckoCoinApi);

    }

    @Test
    void getStandardCoinsTest() {
        //GIVEN
        GeckoCoinApi testgeckoCoinApi = getMockedGeckoCoinApi();
        CoinIdCard testcoinIdCard = getMockedCoin();

        CoinGeckoApiService coinGeckoApiService = mock(CoinGeckoApiService.class);
        when(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("bitcoin")).thenReturn(testgeckoCoinApi);
        when(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("ethereum")).thenReturn(testgeckoCoinApi);
        when(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("shiba-inu")).thenReturn(testgeckoCoinApi);
        when(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("verge")).thenReturn(testgeckoCoinApi);
        when(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("iotex")).thenReturn(testgeckoCoinApi);
        when(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("troy")).thenReturn(testgeckoCoinApi);
        when(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("lina")).thenReturn(testgeckoCoinApi);
        when(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("ripple")).thenReturn(testgeckoCoinApi);
        when(coinGeckoApiService.getCoinInfoByIdFromCoinGecko("iota")).thenReturn(testgeckoCoinApi);

        CoinFactory coinFactory = mock(CoinFactory.class);
        when(coinFactory.mapToCoin(testgeckoCoinApi)).thenReturn(testcoinIdCard);

        CoinService coinService = new CoinService(coinGeckoApiService, coinFactory);


        //WHEN
        List<CoinIdCard> actual = coinService.getStandardCoins();

        //THEN
        assertThat(actual, is(List.of(
                testcoinIdCard,
                testcoinIdCard,
                testcoinIdCard,
                testcoinIdCard,
                testcoinIdCard,
                testcoinIdCard,
                testcoinIdCard,
                testcoinIdCard,
                testcoinIdCard)));
        verify(coinFactory, times(9)).mapToCoin(testgeckoCoinApi);

    }
}