package com.hallak.GameApp.dtos.House;

import com.hallak.GameApp.dtos.Game.GameDTO;
import com.hallak.GameApp.models.BetType;
import com.hallak.GameApp.models.Role;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HouseDTO {

        private String username;
        private Map<BetType, BigDecimal> odds = new HashMap<>();
        private Set<GameDTO> games;
        private Set<Role> roles;


    public HouseDTO(String username, Map<BetType, BigDecimal> odds, Set<GameDTO> games, Set<Role> roles) {
        this.username = username;
        this.odds = odds;
        this.games = games;
        this.roles = roles;
    }

    public HouseDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<BetType, BigDecimal> getOdds() {
        return odds;
    }

    public void setOdds(Map<BetType, BigDecimal> odds) {
        this.odds = odds;
    }

    public Set<GameDTO> getGames() {
        return games;
    }

    public void setGames(Set<GameDTO> games) {
        this.games = games;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
