package com.hallak.BetApp.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_bet")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BetType type;

    private List<Integer> values;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Long gameId;


    public Bet(Long id, BetType type, List<Integer> values, LocalDateTime date, User user, Long gameId) {
        this.id = id;
        this.type = type;
        this.values = values;
        this.date = date;
        this.user = user;
        this.gameId = gameId;
    }

    public Bet() {
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

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bet bet = (Bet) o;
        return Objects.equals(id, bet.id) && type == bet.type && Objects.equals(values, bet.values) && Objects.equals(date, bet.date) && Objects.equals(user, bet.user) && Objects.equals(gameId, bet.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, values, date, user, gameId);
    }
}
