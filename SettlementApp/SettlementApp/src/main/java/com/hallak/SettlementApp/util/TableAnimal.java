package com.hallak.SettlementApp.util;

import java.util.*;

public class TableAnimal {

     private static final Map<String, List<Integer>> animalMap;

    static {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("avestruz", Arrays.asList(1, 2, 3, 4));
        map.put("aguia", Arrays.asList(5, 6, 7, 8));
        map.put("burro", Arrays.asList(9, 10, 11, 12));
        map.put("borboleta", Arrays.asList(13, 14, 15, 16));
        map.put("cachorro", Arrays.asList(17, 18, 19, 20));
        map.put("cabra", Arrays.asList(21, 22, 23, 24));
        map.put("carneiro", Arrays.asList(25, 26, 27, 28));
        map.put("camelo", Arrays.asList(29, 30, 31, 32));
        map.put("cobra", Arrays.asList(33, 34, 35, 36));
        map.put("coelho", Arrays.asList(37, 38, 39, 40));
        map.put("cavalo", Arrays.asList(41, 42, 43, 44));
        map.put("elefante", Arrays.asList(45, 46, 47, 48));
        map.put("galo", Arrays.asList(49, 50, 51, 52));
        map.put("gato", Arrays.asList(53, 54, 55, 56));
        map.put("jacare", Arrays.asList(57, 58, 59, 60));
        map.put("leao", Arrays.asList(61, 62, 63, 64));
        map.put("macaco", Arrays.asList(65, 66, 67, 68));
        map.put("porco", Arrays.asList(69, 70, 71, 72));
        map.put("pavao", Arrays.asList(73, 74, 75, 76));
        map.put("peru", Arrays.asList(77, 78, 79, 80));
        map.put("touro", Arrays.asList(81, 82, 83, 84));
        map.put("tigre", Arrays.asList(85, 86, 87, 88));
        map.put("urso", Arrays.asList(89, 90, 91, 92));
        map.put("veado", Arrays.asList(93, 94, 95, 96));
        map.put("vaca", Arrays.asList(97, 98, 99, 0));

        animalMap = Collections.unmodifiableMap(map);
    }

    private TableAnimal() {
    }

    protected static List<Integer> getNumbersForAnimal(String animal) {
        return animalMap.get(animal.toLowerCase());
    }

    protected static Map<String, List<Integer>> getAnimalMap() {
        return animalMap;
    }

    protected static Optional<String> getAnimalByNumber(int number) {
        int num = number % 100;
        for (Map.Entry<String, List<Integer>> entry : animalMap.entrySet()) {
            if (entry.getValue().contains(num)) {
                return Optional.of(entry.getKey());
            }
        }
        return Optional.empty();
    }
}



