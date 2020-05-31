package com.mpecel.currency.controllers;

import com.mpecel.currency.model.OutputCurrencyPairDetails;
import com.mpecel.currency.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CurrencyController {

    private CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping(value = "pair/{pair}")
    public OutputCurrencyPairDetails getCurrencyPair(@PathVariable String pair) {
        return currencyService.getOutput(pair);
    }

    @GetMapping(value = "pairs")
    public Collection<OutputCurrencyPairDetails> getCurrencyPairs() {
        return currencyService.getOutput();
    }

}













