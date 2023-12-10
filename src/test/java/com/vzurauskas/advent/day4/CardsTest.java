package com.vzurauskas.advent.day4;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

final class CardsTest {

    @Test
    void winsCardsTrivial() {
        assertEquals(
            8,
            new Cards(
                List.of(
                    new Card("Card 1: 1 2 | 1 2"), // 1
                    new Card("Card 2: 1 | 1"),  // 2
                    new Card("Card 3: 1 2 3 | 99 98 97 96 95 94 93"), // 4
                    new Card("Card 4: 1 2 3 | 99 98 97 96 95 94 93") // 1
                )
            ).scratch()
        );
    }

    @Test
    void winsCardsSimple() {
        assertEquals(
            10,
            new Cards(
                List.of(
                    new Card("Card 1: 1 2 3 86 17 | 1 2 99 98 97 96"),  // 1
                    new Card("Card 2: 1 32 20 16 61 | 1 99 98 97 96"),  // 2
                    new Card("Card 3: 21 53 59 44 | 99 98 97 96 95 94 93"), // 4
                    new Card("Card 4: 21 53 59 44 | 99 98 97 96 95 94 93"), // 1
                    new Card("Card 5: 21 53 59 44 | 99 98 97 96 95 94 93"), // 1
                    new Card("Card 6: 21 53 59 44 | 99 98 97 96 95 94 93")  // 1
                )
            ).scratch()
        );
    }

    @Test
    void winsCards() {
        assertEquals(
            30,
            new Cards(
                List.of(
                    new Card("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"), // 1
                    new Card("Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19"), // 2
                    new Card("Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1"), // 4
                    new Card("Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83"), // 8
                    new Card("Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36"), // 14
                    new Card("Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11") // 1
                )
            ).scratch()
        );
    }
}
