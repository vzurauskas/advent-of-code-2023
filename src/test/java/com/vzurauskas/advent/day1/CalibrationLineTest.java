package com.vzurauskas.advent.day1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

final class CalibrationLineTest {

    @Test
    void decodesInput1() {
        assertEquals(
            12,
            new CalibrationLine("1abc2").value()
        );
    }

    @Test
    void decodesInput2() {
        assertEquals(
            38,
            new CalibrationLine("pqr3stu8vwx").value()
        );
    }

    @Test
    void decodesInput3() {
        assertEquals(
            15,
            new CalibrationLine("a1b2c3d4e5f").value()
        );
    }

    @Test
    void decodesInput4() {
        assertEquals(
            77,
            new CalibrationLine("treb7uchet").value()
        );
    }
}
