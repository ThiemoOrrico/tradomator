package com.tradomator.model.coingeckoapi;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tradomator.model.CurrentAvgPrice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarketDataApi {
@JsonProperty("current_price")
    private CurrentAvgPrice currentPriceApi;

}