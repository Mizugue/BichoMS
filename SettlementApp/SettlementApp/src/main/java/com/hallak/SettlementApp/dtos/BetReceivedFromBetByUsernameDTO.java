package com.hallak.SettlementApp.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class BetReceivedFromBetByUsernameDTO {
    private Long id;
    private BetType type;
    private List<String> values;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime date;
    private Double amount;
    private GameInterServiceDTO game;
    private  UserDTO user;

    public BetReceivedFromBetByUsernameDTO(Long id, BetType type, List<String> values, LocalDateTime date, Double amount, GameInterServiceDTO game, UserDTO user) {
        this.id = id;
        this.type = type;
        this.values = values;
        this.date = date;
        this.amount = amount;
        this.game = game;
        this.user = user;
    }

    public BetReceivedFromBetByUsernameDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}