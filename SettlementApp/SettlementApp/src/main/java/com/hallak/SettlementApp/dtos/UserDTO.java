package com.hallak.SettlementApp.dtos;

public class UserDTO {
    private String email;
    private String username;

    public UserDTO(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public UserDTO(){
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
}

