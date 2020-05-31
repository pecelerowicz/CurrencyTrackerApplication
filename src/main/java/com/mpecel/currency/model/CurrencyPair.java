package com.mpecel.currency.model;

public enum CurrencyPair {

    ETHEUR("ETH-EUR", "ETHEUR"),
    ETHUSD("ETH-USD", "ETHUSD"),
    BTCEUR("BTC-EUR", "BTCEUR"),
    BTCUSD("BTC-USD", "BTCUSD");

    private final String inId;
    private final String outId;

    CurrencyPair(String inId, String outId) {
        this.inId = inId;
        this.outId = outId;
    }

    public String getInId() {
        return inId;
    }

    public String getOutId() {
        return outId;
    }

    public static CurrencyPair fromInId(String inId) {
        if(inId.equals(ETHEUR.inId))
            return ETHEUR;
        if(inId.equals(ETHUSD.inId))
            return ETHUSD;
        if(inId.equals(BTCEUR.inId))
            return BTCEUR;
        if(inId.equals(BTCUSD.inId))
            return BTCUSD;
        throw new RuntimeException("Wrong address!");
    }

    public static CurrencyPair fromOutId(String outId) {
        if(outId.equals(ETHEUR.outId))
            return ETHEUR;
        if(outId.equals(ETHUSD.outId))
            return ETHUSD;
        if(outId.equals(BTCEUR.outId))
            return BTCEUR;
        if(outId.equals(BTCUSD.outId))
            return BTCUSD;
        throw new RuntimeException("Wrong address!");
    }
}
