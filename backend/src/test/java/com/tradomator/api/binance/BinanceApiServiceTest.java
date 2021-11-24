package com.tradomator.api.binance;

import com.tradomator.service.binance.BinanceApiService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;


class BinanceApiServiceTest {

    private final String BINANCE_API_TEST_BASEURL = "https://testnet.binance.vision/api/v3/";
    private RestTemplate restTemplate = mock(RestTemplate.class);
    private BinanceApiService binanceApiService = new BinanceApiService(restTemplate);

    @Test
    void isPing_expectsTrue() {
        //GIVEN
        when(restTemplate.getForEntity(BINANCE_API_TEST_BASEURL + "ping", String.class)).thenReturn(ResponseEntity.ok("{}"));

        //WHEN
        boolean actual = binanceApiService.isPing();

        //THEN
        assertThat(actual, is(true));
        verify(restTemplate).getForEntity(BINANCE_API_TEST_BASEURL + "ping", String.class);
    }

    @Test
    void isPing_expectsFalse() {
        //GIVEN
        when(restTemplate.getForEntity(BINANCE_API_TEST_BASEURL + "ping", String.class)).thenReturn(ResponseEntity.internalServerError().build());

        //WHEN
        boolean actual = binanceApiService.isPing();

        //THEN
        assertThat(actual, is(false));
        verify(restTemplate).getForEntity(BINANCE_API_TEST_BASEURL + "ping", String.class);
    }

}