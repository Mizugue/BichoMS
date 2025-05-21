package com.hallak.SettlementApp.util;

import java.util.ArrayList;
import java.util.List;

public class NumberPermutationGenerator {

    public static List<String> generatePermutation(String number) {
        List<String> results = new ArrayList<>();
        doPermutation("", number, results);
        return results;
    }

    private static void doPermutation(String prefix, String rest, List<String> results) {
        int n = rest.length();
        if (n == 0) {
            results.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                doPermutation(prefix + rest.charAt(i),
                         rest.substring(0, i) + rest.substring(i + 1, n),
                         results);
            }
        }
    }


}
