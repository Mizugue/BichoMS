package com.hallak.SettlementApp.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class SettlementDTO {


    private BetType type;
    private FinalBetStatus finalBetStatus;
    private List<String> consideredValues;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime date;
    private Double amount;
    private GameInterServiceDTO game;


    public SettlementDTO(BetType type, FinalBetStatus finalBetStatus, List<String> consideredValues, LocalDateTime date, Double amount, GameInterServiceDTO game) {
        this.type = type;
        this.finalBetStatus = finalBetStatus;
        this.consideredValues = consideredValues;
        this.date = date;
        this.amount = amount;
        this.game = game;
    }

    public SettlementDTO() {
    }

    public BetType getType() {
        return type;
    }

    public void setType(BetType type) {
        this.type = type;
    }

    public List<String> getConsideredValues() {
        return consideredValues;
    }

    public void setConsideredValues(List<String> consideredValues) {
        this.consideredValues = consideredValues;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public GameInterServiceDTO getGame() {
        return game;
    }

    public void setGame(GameInterServiceDTO game) {
        this.game = game;
    }

    public FinalBetStatus getFinalBetStatus() {
        return finalBetStatus;
    }

    public void setFinalBetStatus(FinalBetStatus finalBetStatus) {
        this.finalBetStatus = finalBetStatus;
    }
}
