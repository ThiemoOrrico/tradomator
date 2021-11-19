package com.tradomator.service.coingeckoapi;

import com.tradomator.model.dto.coingeckoapi.CgeckoApiCoin;
import com.tradomator.model.dto.coingeckoapi.CurrentPriceApi;
import com.tradomator.model.dto.coingeckoapi.ImageApi;
import com.tradomator.model.dto.coingeckoapi.MarketDataApi;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class CoingeckoApiServiceTest {

    private RestTemplate restTemplate = mock(RestTemplate.class);

    private CoingeckoApiService coingeckoApiService = new CoingeckoApiService(restTemplate);

    @Test
    void getSingleCoinByIdFromCoingecko_shouldReturnSingleCoinFromCoingeckoApi() {
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


        when(restTemplate.getForEntity(
                "https://api.coingecko.com/api/v3/coins/bitcoin",
                CgeckoApiCoin.class)

        ).thenReturn(ResponseEntity.ok(cgeckoApiCoin1));

        //WHEN
        CgeckoApiCoin actual = coingeckoApiService.getCgeckoCoinById("bitcoin");

        //THEN
        assertThat(actual, is(cgeckoApiCoin1));
        verify(restTemplate).getForEntity("https://api.coingecko.com/api/v3/coins/bitcoin", CgeckoApiCoin.class);

    }
}