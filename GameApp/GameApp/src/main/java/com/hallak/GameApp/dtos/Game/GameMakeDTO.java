package com.hallak.GameApp.dtos.Game;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class GameMakeDTO {

    private Long id;
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime captureDate;

    public GameMakeDTO(Long id, String name, LocalDateTime captureDate) {
        this.id = id;
        this.name = name;
        this.captureDate = captureDate;
    }

    public GameMakeDTO() {
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

    public LocalDateTime getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(LocalDateTime captureDate) {
        this.captureDate = captureDate;
    }
}
