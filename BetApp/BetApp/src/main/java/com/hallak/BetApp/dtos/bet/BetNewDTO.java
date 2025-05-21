package com.hallak.BetApp.dtos.bet;

import com.hallak.BetApp.models.BetType;

import java.util.List;

public class BetNewDTO {

    private BetType type;
    private List<String> values;
    private Long gameId;
    private Double amount;

    public BetNewDTO(BetType type, List<String> values, Long gameId, Double amount) {
        this.type = type;
        this.values = values;
        this.gameId = gameId;
        this.amount = amount;
    }

    public BetNewDTO() {
    }

    public BetType getType() {
        return type;
    }

    public void setType(BetType type) {
        this.type = type;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
