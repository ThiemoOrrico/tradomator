package com.tradomator.service.binance;

import com.tradomator.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BinanceApiService {

    private static final String BINANCE_API_TEST_URL = "https://testnet.binance.vision/api/v3/";

    private final RestTemplate restTemplate;

    @Value("${com.tradomator.wallet.binance.signature}")
    private String signature;

    @Value("${com.tradomator.wallet.binance.apikey}")
    private String apikey;

    @Autowired
    public BinanceApiService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }



        public boolean isPing (){

        ResponseEntity<String> pingResponse= restTemplate.getForEntity(BINANCE_API_TEST_URL +"ping", String.class);
        return pingResponse.getStatusCode().equals(HttpStatus.OK);

        }

    public Wallet getAccountInfo (){

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-MBX-APIKEY", apikey);

        long timestamp = System.currentTimeMillis();

        ResponseEntity<Wallet> walletResponse= restTemplate.exchange(BINANCE_API_TEST_URL +"account?timestamp="+ timestamp + "&signatur=" + signature, HttpMethod.GET, new HttpEntity<>(headers), Wallet.class );
        return walletResponse.getBody();


    }

}
