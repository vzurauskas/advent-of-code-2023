package com.vzurauskas.advent.day4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

final class CardTest {
    @Test
    void calculatesValue1() {
        assertEquals(
            8,
            new Card("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53").value()
        );
    }
}
