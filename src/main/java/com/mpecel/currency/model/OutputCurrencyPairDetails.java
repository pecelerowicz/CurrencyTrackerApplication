package com.mpecel.currency.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class OutputCurrencyPairDetails {

    private String instrument;
    private Double bid;
    private Double ask;
    private Double last;
    private String time;

}
