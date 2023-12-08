package com.vzurauskas.advent.day3;

import com.vzurauskas.advent.tech.LinesOfFile;

public final class Solution {
    private final Grid grid;

    Solution() {
        this.grid = new Grid()
            .fill(
                new LinesOfFile(
                    "com\\vzurauskas\\advent\\day3\\input.txt"
                ).value()
            )
            .enrich();
    }

    @Override
    public String toString() {
        return String.valueOf(grid.sumOfNumbers());
    }
}
