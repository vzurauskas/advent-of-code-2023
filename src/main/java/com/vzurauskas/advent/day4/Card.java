package com.vzurauskas.advent.day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class Card {
    private final Set<Integer> winning;
    private final Set<Integer> actual;

    public Card(String line) {
        this(
            toSet(line.split("\\|")[0].split(":")[1]),
            toSet(line.split("\\|")[1])
        );
    }

    private static Set<Integer> toSet(String numbers) {
        return Arrays.stream(numbers.split(" "))
            .map(String::trim)
            .filter(num -> !num.isEmpty())
            .map(Integer::parseInt)
            .collect(Collectors.toSet());
    }

    private Card(Set<Integer> winning, Set<Integer> actual) {
        this.winning = winning;
        this.actual = actual;
    }

    public int value() {
        Set<Integer> temp = new HashSet<>(actual);
        temp.retainAll(winning);
        int matches = temp.size();
        if (matches == 0) {
            return 0;
        } else if (matches == 1) {
            return 1;
        } else {
            return (int) Math.pow(2, matches - 1);
        }

    }
}
