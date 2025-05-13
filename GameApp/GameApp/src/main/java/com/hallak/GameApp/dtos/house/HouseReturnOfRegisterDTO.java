package com.hallak.GameApp.dtos.house;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hallak.GameApp.models.Role;

import java.util.HashSet;
import java.util.Set;

public class HouseReturnOfRegisterDTO {

    private String username;
    @JsonIgnore
    private String password;
    private Set<Role> roles = new HashSet<>();

    public HouseReturnOfRegisterDTO(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public HouseReturnOfRegisterDTO() {
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
