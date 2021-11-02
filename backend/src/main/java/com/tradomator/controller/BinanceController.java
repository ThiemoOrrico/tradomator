package com.tradomator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/binance-api/")
public class BinanceController {

    @GetMapping
    public String helloWorld() {
        return "Placeholder for Binance Response";
    }


}
