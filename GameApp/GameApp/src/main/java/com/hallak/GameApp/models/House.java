package com.hallak.GameApp.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "tb_house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String password;

    private Map<BetType, BigDecimal> odds = new HashMap<>();

    public House(Long id, String name, String password, Map<BetType, BigDecimal> odds) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.odds = odds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<BetType, BigDecimal> getOdds() {
        return odds;
    }

    public void setOdds(Map<BetType, BigDecimal> odds) {
        this.odds = odds;
    }
}
