package com.hallak.ResultApp.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.Objects;

public class ResultDTO {

    private String first;
    private String second;
    private String third;
    private String fourth;
    private String fifth;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;

    public ResultDTO(String first, String second, String third, String fourth, String fifth, LocalDateTime date) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.date = date;
    }

    public ResultDTO() {
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getFourth() {
        return fourth;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    public String getFifth() {
        return fifth;
    }

    public void setFifth(String fifth) {
        this.fifth = fifth;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultDTO resultDTO = (ResultDTO) o;
        return Objects.equals(first, resultDTO.first) && Objects.equals(second, resultDTO.second) && Objects.equals(third, resultDTO.third) && Objects.equals(fourth, resultDTO.fourth) && Objects.equals(fifth, resultDTO.fifth) && Objects.equals(date, resultDTO.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third, fourth, fifth, date);
    }
}
