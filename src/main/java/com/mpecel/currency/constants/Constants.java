package com.mpecel.currency.constants;

import com.mpecel.currency.model.CurrencyPair;
import com.mpecel.currency.model.OutputCurrencyPairDetails;

import javax.json.*;
import java.time.format.DateTimeFormatter;

public class Constants {

    public static final String URI = "wss://ws-feed.pro.coinbase.com";

    public static final String SUBSCRIPTION_PAYLOAD =
            Json.createObjectBuilder()
            .add("type", "subscribe")
            .add("channels",
                    Json.createArrayBuilder()
                    .add(
                            Json.createObjectBuilder()
                            .add("name", "ticker")
                            .add("product_ids",
                                    Json.createArrayBuilder()
                                    .add(CurrencyPair.ETHEUR.getInId())
                                    .add(CurrencyPair.ETHUSD.getInId())
                                    .add(CurrencyPair.BTCEUR.getInId())
                                    .add(CurrencyPair.BTCUSD.getInId()))
                    ))
            .build()
            .toString();

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static final OutputCurrencyPairDetails EMPTY_OUTPUT = new OutputCurrencyPairDetails("no value", 0.,
            0., 0., "no value");

}
