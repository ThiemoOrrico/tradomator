package com.tradomator.service.binance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BinanceApiService {

    private static final String BINANCE_API_TEST_URL = "https://testnet.binance.vision/api/v3/";

    private final RestTemplate restTemplate;

    @Autowired
    public BinanceApiService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }



        public boolean isPing (){

        ResponseEntity<String> pingResponse= restTemplate.getForEntity(BINANCE_API_TEST_URL +"ping", String.class);
        return pingResponse.getStatusCode().equals(HttpStatus.OK);

        }


}
