package com.vzurauskas.advent.day3;

import com.vzurauskas.advent.tech.LinesOfFile;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

final class GridTest {

    @Test
    void coordinatesWork() {
        assertEquals(
            "*",
            new Grid().fill(
                new LinesOfFile(
                    "com\\vzurauskas\\advent\\day3\\simple.txt"
                ).value()
            ).at(3, 1).literal()
        );
    }

    @Test
    void numbersWork() {
        assertEquals(
            633,
            new Grid()
                .fill(
                    new LinesOfFile(
                        "com\\vzurauskas\\advent\\day3\\simple.txt"
                    ).value()
                )
                .enrich()
                .numberAt(7, 2).value()
        );
    }
}
