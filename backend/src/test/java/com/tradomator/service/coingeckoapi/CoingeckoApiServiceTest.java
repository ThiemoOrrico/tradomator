package com.tradomator.service.coingeckoapi;

import com.tradomator.model.CoinIdCard;
import com.tradomator.model.coingeckoapi.CgeckoApiCoin;
import com.tradomator.service.CoinService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class CoingeckoApiServiceTest {

    @MockBean
    private CoingeckoApiService coinGeckoApiService;

    @Autowired
    private CoinService coinService;

    @Test
    void test_getCgeckoCoinInfoById_whenEmpty() {
        // GIVEN
        when(coinGeckoApiService.getCgeckoCoinInfoById()).thenReturn(new CgeckoApiCoin[]{});

        List<CoinIdCard> expected = List.of();

        // WHEN
        List<CoinIdCard> response = coinService.getCoinDataById();

        // THEN
        assertEquals(expected, response);

    }
}