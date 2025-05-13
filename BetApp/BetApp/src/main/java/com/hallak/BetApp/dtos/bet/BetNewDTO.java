package com.hallak.BetApp.dtos.bet;

import com.hallak.BetApp.models.BetType;

import java.util.List;

public class BetNewDTO {

    private BetType type;
    private List<Integer> values;
    private Long gameId;

    public BetNewDTO(BetType type, List<Integer> values, Long gameId) {
        this.type = type;
        this.values = values;
        this.gameId = gameId;
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

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
