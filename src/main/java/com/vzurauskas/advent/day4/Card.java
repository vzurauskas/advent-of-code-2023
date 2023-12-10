package com.vzurauskas.advent.day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class Card implements Comparable<Card> {
    private final int id;
    private final Set<Integer> winning;
    private final Set<Integer> actual;

    public Card(String line) {
        this(
            Integer.parseInt(line.split("\\|")[0].split(":")[0].replaceAll("[^\\d]", "")),
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

    private Card(int id, Set<Integer> winning, Set<Integer> actual) {
        this.id = id;
        this.winning = winning;
        this.actual = actual;
    }

    public int id() {
        return id;
    }

    public int points() {
        int matches = matches();
        if (matches == 0) {
            return 0;
        } else if (matches == 1) {
            return 1;
        } else {
            return (int) Math.pow(2, matches - 1);
        }
    }

    public int matches() {
        Set<Integer> matches = new HashSet<>(actual);
        matches.retainAll(winning);
        return matches.size();
    }

    @Override
    public int compareTo(Card other) {
        return this.id() - other.id();
    }

    public Card copy() {
        return new Card(id, winning, actual);
    }
}
