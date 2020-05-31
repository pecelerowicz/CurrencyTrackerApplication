package com.mpecel.currency.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mpecel.currency.model.CurrencyPair;
import com.mpecel.currency.model.InputCurrencyPairDetails;
import com.mpecel.currency.model.OutputCurrencyPairDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.mpecel.currency.constants.Constants.*;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private ObjectMapper objectMapper;
    private Map<CurrencyPair, OutputCurrencyPairDetails> outputMap;

    @Autowired
    public CurrencyServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;

        this.outputMap = new HashMap<>();
        this.outputMap.put(CurrencyPair.BTCUSD, EMPTY_OUTPUT);
        this.outputMap.put(CurrencyPair.BTCEUR, EMPTY_OUTPUT);
        this.outputMap.put(CurrencyPair.ETHUSD, EMPTY_OUTPUT);
        this.outputMap.put(CurrencyPair.ETHEUR, EMPTY_OUTPUT);
    }

    @Override
    public void createOutput(String value) throws IOException{

        InputCurrencyPairDetails inputCurrencyPairDetails = objectMapper.readValue(value, InputCurrencyPairDetails.class);

        if(inputCurrencyPairDetails != null && inputCurrencyPairDetails.getInId() != null) {
            OutputCurrencyPairDetails outputCurrencyPairDetails = inputOutputTransform(inputCurrencyPairDetails);
            outputMap.put(CurrencyPair.fromOutId(outputCurrencyPairDetails.getInstrument()), outputCurrencyPairDetails);
        }
    }

    @Override
    public OutputCurrencyPairDetails getOutput(String pair) {
        return outputMap.get(CurrencyPair.fromOutId(pair.toUpperCase()));
    }

    private OutputCurrencyPairDetails inputOutputTransform(InputCurrencyPairDetails inputCurrencyPairDetails) {
        return new OutputCurrencyPairDetails(
                CurrencyPair.fromInId(inputCurrencyPairDetails.getInId()).getOutId(),
                Double.valueOf(inputCurrencyPairDetails.getBestBid()),
                Double.valueOf(inputCurrencyPairDetails.getBestAsk()),
                Double.valueOf(inputCurrencyPairDetails.getPrice()),
                inputCurrencyPairDetails.getTime().toLocalTime().format(TIME_FORMATTER));
    }
}
