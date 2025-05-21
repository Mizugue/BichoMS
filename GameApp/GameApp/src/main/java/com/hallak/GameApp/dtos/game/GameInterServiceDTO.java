package com.hallak.GameApp.dtos.game;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hallak.GameApp.dtos.house.HouseFromGISDTO;

import java.time.LocalDateTime;
import java.util.Objects;

public class GameInterServiceDTO {

    private Long id;
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime creationDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime captureDate;

    private HouseFromGISDTO house;

    public GameInterServiceDTO(Long id, String name, LocalDateTime creationDate, LocalDateTime captureDate, HouseFromGISDTO house) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.captureDate = captureDate;
        this.house = house;
    }

    public GameInterServiceDTO() {
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

    public HouseFromGISDTO getHouse() {
        return house;
    }

    public void setHouse(HouseFromGISDTO house) {
        this.house = house;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameInterServiceDTO that = (GameInterServiceDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(creationDate, that.creationDate) && Objects.equals(captureDate, that.captureDate) && Objects.equals(house, that.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creationDate, captureDate, house);
    }
}
