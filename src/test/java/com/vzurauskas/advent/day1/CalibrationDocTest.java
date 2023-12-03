package com.vzurauskas.advent.day1;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

final class CalibrationDocTest {

    @Test
    void sumsLines() {
        assertEquals(
            36,
            new CalibrationDoc(
                List.of(
                    "a1g2",
                    "a1g2",
                    "a1g2"
                )
            ).value()
        );
    }
}
