package com.hallak.GameApp.dtos;

public class HouseRegisterDTO {

    private String username;
    private String password;

    public HouseRegisterDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public HouseRegisterDTO() {
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
}
