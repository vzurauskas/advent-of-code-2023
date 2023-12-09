package com.vzurauskas.advent.day4;

import com.vzurauskas.advent.tech.LinesOfFile;

import java.util.List;
import java.util.stream.Collectors;

public final class Solution {
    private final List<Card> cards;

    Solution() {
        this.cards = new LinesOfFile("com\\vzurauskas\\advent\\day4\\input.txt")
            .value().stream()
            .map(Card::new)
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.valueOf(
            cards.stream()
                .mapToInt(Card::value)
                .sum()
        );
    }
}
