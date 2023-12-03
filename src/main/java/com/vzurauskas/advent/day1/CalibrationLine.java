package com.vzurauskas.advent.day1;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CalibrationLine {
    private final String line;

    public CalibrationLine(String line) {
        this.line = line;
    }

    public int value() {
        List<String> chars = withNumbersFixed().chars()
            .filter(Character::isDigit)
            .mapToObj(c -> String.valueOf((char) c))
            .map(String::valueOf)
            .collect(Collectors.toList());
        String first = chars.get(0);
        String last = chars.get(chars.size() - 1);
        return Integer.parseInt(first + last);
    }

    private String withNumbersFixed() {
        String previous = line;
        String replaced = withFirstReplaced(previous);
        while (!previous.equals(replaced)) {
            previous = replaced;
            replaced = withFirstReplaced(previous);
        }
        return replaced;
    }

    private static String withFirstReplaced(String line) {
        List<ReplacementCandidate> candidates = Stream.of(
            new ReplacementCandidate(line, "one", 1),
            new ReplacementCandidate(line, "two", 2),
            new ReplacementCandidate(line, "three", 3),
            new ReplacementCandidate(line, "four", 4),
            new ReplacementCandidate(line, "five", 5),
            new ReplacementCandidate(line, "six", 6),
            new ReplacementCandidate(line, "seven", 7),
            new ReplacementCandidate(line, "eight", 8),
            new ReplacementCandidate(line, "nine", 9)
        )
            .filter(candidate -> line.contains(candidate.word()))
            .collect(Collectors.toList());
        return candidates.isEmpty()
            ? line
            : Collections.max(candidates).apply();
    }
}
