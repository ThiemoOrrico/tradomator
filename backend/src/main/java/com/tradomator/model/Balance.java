package com.tradomator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Balance {

    private String asset;
    private String free;
    private String locked;

}
