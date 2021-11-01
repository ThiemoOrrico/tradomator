package com.tradomator.model.coingeckoapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GeckoCoinApi {
    private String id;
    private String symbol;
    private String name;
    @JsonProperty("market_data")
    private MarketDataApi marketData;

    private ImageApi image;
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
}
