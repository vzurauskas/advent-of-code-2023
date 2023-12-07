package com.vzurauskas.advent.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

final class GameTest {

    @Test
    void parsesId() {
        assertEquals(
            1,
            new Game(
                "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
            ).id()
        );
    }

    @Test
    void tellsIfPossible1() {
        assertTrue(
            new Game(
                "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
            ).isPossible()
        );
    }

    @Test
    void tellsIfPossible2() {
        assertTrue(
            new Game(
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"
            ).isPossible()
        );
    }

    @Test
    void tellsIfPossible3() {
        assertFalse(
            new Game(
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"
            ).isPossible()
        );
    }

    @Test
    void tellsIfPossible4() {
        assertFalse(
            new Game(
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"
            ).isPossible()
        );
    }

    @Test
    void tellsIfPossible5() {
        assertTrue(
            new Game(
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
            ).isPossible()
        );
    }
}
