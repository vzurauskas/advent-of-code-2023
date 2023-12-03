package com.vzurauskas.advent.day1;

import java.util.List;
import java.util.stream.Collectors;

public final class CalibrationLine {
    private final String line;

    public CalibrationLine(String line) {
        this.line = line;
    }

    public int value() {
        List<String> chars = line.chars()
            .filter(Character::isDigit)
            .mapToObj(c -> String.valueOf((char) c))
            .map(String::valueOf)
            .collect(Collectors.toList());
        String first = chars.get(0);
        String last = chars.get(chars.size() - 1);
        return Integer.parseInt(first + last);
    }
}
