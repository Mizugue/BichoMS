package com.hallak.BetApp.dtos.bet;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hallak.BetApp.models.BetType;

import java.time.LocalDateTime;
import java.util.List;

public class BetReturnOfNewDTO {

    private BetType type;
    private List<Integer> values;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime date;

    public BetReturnOfNewDTO(BetType type, List<Integer> values, LocalDateTime date) {
        this.type = type;
        this.values = values;
        this.date = date;
    }

    public BetReturnOfNewDTO() {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
