package com.vzurauskas.advent.day4;

import com.vzurauskas.advent.tech.LinesOfFile;

import java.util.stream.Collectors;

public final class Solution {
    private final Cards cards;

    Solution() {
        this.cards = new Cards(
            new LinesOfFile("com\\vzurauskas\\advent\\day4\\input.txt")
                .value().stream()
                .map(Card::new)
                .collect(Collectors.toList())
        );
    }

    @Override
    public String toString() {
        return String.valueOf(cards.scratch());
    }
}
