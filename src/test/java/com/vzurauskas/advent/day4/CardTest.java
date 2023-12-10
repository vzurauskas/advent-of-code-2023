package com.vzurauskas.advent.day4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

final class CardTest {

    @Test
    void knowsId() {
        assertEquals(
            1,
            new Card("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53").id()
        );
    }

    @Test
    void calculatesPoints() {
        assertEquals(
            8,
            new Card("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53").points()
        );
    }

    @Test
    void calculatesMatches() {
        assertEquals(
            10,
            new Card("Card   3: 47 97  2 80 89 56 66 85 62 46 | 78 97 47 14 15 85 42 66 24 28 54 46 89 62 80 56 22  5 57 52 69  2  3 95 19").matches()
        );
    }
}
