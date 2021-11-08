package com.tradomator.service.coingeckoapi;

import com.tradomator.model.coingeckoapi.CgeckoApiCoin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoinGeckoApiService {

    /*private final WebClient webClient;


    @Autowired
    public CoinGeckoApiService (WebClient webClient){
        this.webClient = webClient;
    }

    public GeckoCoinApi getCoinInfoByIdFromCoinGecko(String coinId){
        return webClient
                .get()
                .uri("/coins/" + coinId)
                .retrieve()
                .bodyToMono(GeckoCoinApi.class)
                .block(Duration.ofSeconds(3));
    }
*/

    private static final String COINGECKO_API_URL = "https://api.coingecko.com/api/v3/";
    private final RestTemplate restTemplate = new RestTemplate();

    public CgeckoApiCoin[] getCgeckoCoinInfoById(){

        ResponseEntity<CgeckoApiCoin[]> response = restTemplate.getForEntity(COINGECKO_API_URL, CgeckoApiCoin[].class);
        return response.getBody();
    }
}
