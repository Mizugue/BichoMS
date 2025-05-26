package com.hallak.BetApp.dtos.bet;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hallak.BetApp.dtos.external.GameInterServiceDTO;
import com.hallak.BetApp.models.BetType;

import java.time.LocalDateTime;
import java.util.List;

public class BetToFindAllDTO {

    private Long id;
    private BetType type;
    private List<String> values;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime date;
    private Double amount;
    private GameInterServiceDTO game;

    public BetToFindAllDTO(BetType type, List<String> values, LocalDateTime date, Double amount, GameInterServiceDTO game, Long id) {
        this.id = id;
        this.type = type;
        this.values = values;
        this.date = date;
        this.amount = amount;
        this.game = game;
    }

    public BetToFindAllDTO() {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public GameInterServiceDTO getGame() {
        return game;
    }

    public void setGame(GameInterServiceDTO game) {
        this.game = game;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


