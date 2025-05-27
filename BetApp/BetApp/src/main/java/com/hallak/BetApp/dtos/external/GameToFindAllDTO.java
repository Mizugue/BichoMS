package com.hallak.BetApp.dtos.external;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class GameToFindAllDTO {

    private Long id;
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime captureDate;

    private HouseToFindAllDTO house;

    public GameToFindAllDTO(Long id, String name, LocalDateTime creationDate, LocalDateTime captureDate, HouseToFindAllDTO house) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.captureDate = captureDate;
        this.house = house;
    }

    public GameToFindAllDTO() {
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(LocalDateTime captureDate) {
        this.captureDate = captureDate;
    }

    public HouseToFindAllDTO getHouse() {
        return house;
    }

    public void setHouse(HouseToFindAllDTO house) {
        this.house = house;
    }
}
