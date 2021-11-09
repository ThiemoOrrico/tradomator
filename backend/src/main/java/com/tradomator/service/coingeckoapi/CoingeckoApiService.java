package com.tradomator.service.coingeckoapi;

import com.tradomator.model.coingeckoapi.CgeckoApiCoin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoingeckoApiService {

    private static final String COINGECKO_API_URL = "https://api.coingecko.com/api/v3/coins";
    private final RestTemplate restTemplate = new RestTemplate();

    public CgeckoApiCoin[] getCgeckoCoinInfoById(){

        ResponseEntity<CgeckoApiCoin[]> response = restTemplate
                .getForEntity(COINGECKO_API_URL, CgeckoApiCoin[].class);
        return response.getBody();
    }
}
