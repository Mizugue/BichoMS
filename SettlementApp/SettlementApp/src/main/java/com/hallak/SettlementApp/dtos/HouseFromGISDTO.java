package com.hallak.SettlementApp.dtos;

public class HouseFromGISDTO {

    private String username;

    public HouseFromGISDTO(String username) {
        this.username = username;
    }

    public HouseFromGISDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
