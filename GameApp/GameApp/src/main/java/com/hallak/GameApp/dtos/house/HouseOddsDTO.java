package com.hallak.GameApp.dtos.house;

import java.math.BigDecimal;
import java.util.Map;

public class HouseOddsDTO {
    private Map<String, BigDecimal> odds;

    public HouseOddsDTO(){
    }

    public HouseOddsDTO(Map<String, BigDecimal> odds) {
        this.odds = odds;
    }

    public Map<String, BigDecimal> getOdds() {
        return odds;
    }

    public void setOdds(Map<String, BigDecimal> odds) {
        this.odds = odds;
    }
}
