package com.hallak.BetApp.dtos.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hallak.BetApp.dtos.bet.BetNewDTO;
import com.hallak.BetApp.models.Role;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {

    private String email;

    private String username;

    @JsonIgnore
    private String password;

    private Set<BetNewDTO> bets;

    private Set<Role> roles = new HashSet<>();

    public UserDTO(String email, String username, String password, Set<BetNewDTO> bets, Set<Role> roles) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.bets = bets;
        this.roles = roles;
    }

    public UserDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<BetNewDTO> getBets() {
        return bets;
    }

    public void setBets(Set<BetNewDTO> bets) {
        this.bets = bets;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
