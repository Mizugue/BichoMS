package com.hallak.SettlementApp.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ResultReceived {

    private String first;
    private String second;
    private String third;
    private String fourth;
    private String fifth;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;
    private GameInterServiceDTO game;

    public ResultReceived(String first, String second, String third, String fourth, String fifth, LocalDateTime date, GameInterServiceDTO game) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.date = date;
        this.game = game;
    }

    public ResultReceived() {
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getFourth() {
        return fourth;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    public String getFifth() {
        return fifth;
    }

    public void setFifth(String fifth) {
        this.fifth = fifth;
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
}
