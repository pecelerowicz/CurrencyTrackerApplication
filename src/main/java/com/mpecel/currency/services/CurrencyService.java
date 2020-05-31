package com.mpecel.currency.services;

import com.mpecel.currency.model.OutputCurrencyPairDetails;

import java.io.IOException;
import java.util.Collection;

public interface CurrencyService {

    void createOutput(String value) throws IOException;
    OutputCurrencyPairDetails getOutput(String pair);
    Collection<OutputCurrencyPairDetails> getOutput();

}
