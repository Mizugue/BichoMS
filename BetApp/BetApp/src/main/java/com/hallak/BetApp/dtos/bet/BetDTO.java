package com.hallak.BetApp.dtos.bet;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hallak.BetApp.models.BetType;
import com.hallak.BetApp.models.User;

import java.time.LocalDateTime;
import java.util.List;

public class BetDTO {

    private Long id;
    private BetType type;
    private List<Integer> values;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime date;
    private User user;

    public BetDTO(Long id, BetType type, List<Integer> values, LocalDateTime date, User user) {
        this.id = id;
        this.type = type;
        this.values = values;
        this.date = date;
        this.user = user;
    }

    public BetDTO() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
