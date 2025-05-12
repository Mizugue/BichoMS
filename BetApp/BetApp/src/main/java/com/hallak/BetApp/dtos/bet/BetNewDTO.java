package com.hallak.BetApp.dtos.bet;

import com.hallak.BetApp.models.BetType;

import java.util.List;

public class BetNewDTO {

    private BetType type;
    private List<Integer> values;

    public BetNewDTO(BetType type, List<Integer> values) {
        this.type = type;
        this.values = values;
    }

    public BetType getType() {
        return type;
    }

    public void setType(BetType type) {
        this.type = type;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }
}
