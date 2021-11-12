package com.tradomator.service.coingeckoapi;

import com.tradomator.model.coingeckoapi.CgeckoApiCoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoingeckoApiService {

    private static final String COINGECKO_API_URL = "https://api.coingecko.com/api/v3/coins";
    private final RestTemplate restTemplate;

    @Autowired
    public CoingeckoApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CgeckoApiCoin[] getAllCgeckoCoinInfo(){

        ResponseEntity<CgeckoApiCoin[]> response = restTemplate
                .getForEntity(COINGECKO_API_URL, CgeckoApiCoin[].class);
        return response.getBody();
    }

    public CgeckoApiCoin getCgeckoCoinById(String coinId){
        ResponseEntity<CgeckoApiCoin> response = restTemplate
        .getForEntity(COINGECKO_API_URL+ "/" + coinId, CgeckoApiCoin.class);
        return response.getBody();

    }
}
