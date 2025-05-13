package com.hallak.BetApp.dtos.external;

import java.math.BigDecimal;
import java.util.Map;

public class HouseFromGISDTO {


    private Long id;
    private String username;
    private Map<String, BigDecimal> odds;

    public HouseFromGISDTO(Long id, String username, Map<String, BigDecimal> odds) {
        this.id = id;
        this.username = username;
        this.odds = odds;
    }

    public HouseFromGISDTO() {
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

    public Map<String, BigDecimal> getOdds() {
        return odds;
    }

    public void setOdds(Map<String, BigDecimal> odds) {
        this.odds = odds;
    }
}
