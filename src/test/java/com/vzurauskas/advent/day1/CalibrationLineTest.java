package com.vzurauskas.advent.day1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

final class CalibrationLineTest {

    @Test
    void decodesInput1() {
        assertEquals(12, new CalibrationLine("1abc2").value());
    }

    @Test
    void decodesInput2() {
        assertEquals(38, new CalibrationLine("pqr3stu8vwx").value());
    }

    @Test
    void decodesInput3() {
        assertEquals(15, new CalibrationLine("a1b2c3d4e5f").value());
    }

    @Test
    void decodesInput4() {
        assertEquals(77, new CalibrationLine("treb7uchet").value());
    }

    @Test
    void decodesLineWithWords1() {
        assertEquals(29, new CalibrationLine("two1nine").value());
    }

    @Test
    void decodesLineWithWords2() {
        assertEquals(83, new CalibrationLine("eightwothree").value());
    }

    @Test
    void decodesLineWithWords3() {
        assertEquals(13, new CalibrationLine("abcone2threexyz").value());
    }

    @Test
    void decodesLineWithWords4() {
        assertEquals(24, new CalibrationLine("xtwone3four").value());
    }

    @Test
    void decodesLineWithWords5() {
        assertEquals(42, new CalibrationLine("4nineeightseven2").value());
    }

    @Test
    void decodesLineWithWords6() {
        assertEquals(14, new CalibrationLine("zoneight234").value());
    }

    @Test
    void decodesLineWithWords7() {
        assertEquals(76, new CalibrationLine("7pqrstsixteen").value());
    }

    @Test
    void decodesLineWithWords01() {
        assertEquals(48, new CalibrationLine("4eight5mjlkzrgnmlnmxntqmtlxmqlkjccttcpmgznfouroneightk").value());
    }
}
