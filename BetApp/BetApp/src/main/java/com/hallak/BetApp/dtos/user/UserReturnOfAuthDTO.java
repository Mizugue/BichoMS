package com.hallak.BetApp.dtos.user;

public class UserReturnOfAuthDTO {

    private String email;
    private String username;

    public UserReturnOfAuthDTO(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public UserReturnOfAuthDTO(){
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
