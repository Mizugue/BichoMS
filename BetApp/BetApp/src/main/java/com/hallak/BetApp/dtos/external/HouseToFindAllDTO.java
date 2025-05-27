package com.hallak.BetApp.dtos.external;

import java.math.BigDecimal;
import java.util.Map;

public class HouseToFindAllDTO {


    private Long id;
    private String username;


    public HouseToFindAllDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public HouseToFindAllDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}


