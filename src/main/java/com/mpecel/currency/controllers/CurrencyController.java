package com.mpecel.currency.controllers;

import com.mpecel.currency.model.OutputCurrencyPairDetails;
import com.mpecel.currency.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    private CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping(value = "currency/{pair}")
    public OutputCurrencyPairDetails getCurrencyPair(@PathVariable String pair) {
        return currencyService.getOutput(pair);
    }

}













