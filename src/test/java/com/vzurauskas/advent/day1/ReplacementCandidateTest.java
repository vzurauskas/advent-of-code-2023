package com.vzurauskas.advent.day1;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

final class ReplacementCandidateTest {
    @Test
    void isSortedCorrectly() {
        String line = "eightwothree";
        List<ReplacementCandidate> candidates = List.of(
            new ReplacementCandidate(line, "two", 2),
            new ReplacementCandidate(line, "three", 3),
            new ReplacementCandidate(line, "eight", 8)
        );
        assertEquals("eight", Collections.max(candidates).word());
        assertEquals("three", Collections.min(candidates).word());
    }
}
