package com.vzurauskas.advent.day2;

import com.vzurauskas.advent.tech.LinesOfFile;

public final class Solution {
    private final Games games;

    Solution() {
        this.games = new Games(
            new LinesOfFile(
                "com\\vzurauskas\\advent\\day2\\input.txt"
            ).value()
        );
    }

    @Override
    public String toString() {
        return String.valueOf(games.power());
    }
}
