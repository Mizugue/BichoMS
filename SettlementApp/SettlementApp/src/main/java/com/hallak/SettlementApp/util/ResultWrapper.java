package com.hallak.SettlementApp.util;

import com.hallak.SettlementApp.dtos.ResultReceived;

import java.util.List;

public class ResultWrapper {
    private final List<String> values;


    public ResultWrapper(ResultReceived result, Integer toSubstring) {
        this.values = List.of(
            result.getFirst().substring(toSubstring),
            result.getSecond().substring(toSubstring),
            result.getThird().substring(toSubstring),
            result.getFourth().substring(toSubstring),
            result.getFifth().substring(toSubstring)
        );
    }


    public ResultWrapper(ResultReceived result) {
        this.values = List.of(
            result.getFirst(),
            result.getSecond(),
            result.getThird(),
            result.getFourth(),
            result.getFifth()
        );
    }

    public boolean contains(String value) {
        return values.contains(value);
    }

    public List<String> getValues() {
        return values;
    }
}
