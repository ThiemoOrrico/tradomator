package com.tradomator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoinIdCard {
    private String id;
    private String symbol;
    private String name;
    private CurrentPrice currentPrice;
    private String imageUrl;
    private LocalDateTime lastUpdated;
}
