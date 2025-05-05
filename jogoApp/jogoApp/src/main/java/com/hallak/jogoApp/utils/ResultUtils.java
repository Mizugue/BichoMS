package com.hallak.jogoApp.utils;

import com.hallak.jogoApp.dtos.ResultDTO;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ResultUtils {

    public static ResultDTO getNewResult() {
        List<String> numbers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int number = ThreadLocalRandom.current().nextInt(0, 10000);
            numbers.add(String.format("%04d", number));
        }

        return new ResultDTO(
            numbers.getFirst(),
            numbers.get(1),
            numbers.get(2),
            numbers.get(3),
            numbers.getLast(),
            LocalDateTime.now());
    }

}
