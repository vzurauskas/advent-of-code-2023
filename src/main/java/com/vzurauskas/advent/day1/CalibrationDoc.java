package com.vzurauskas.advent.day1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class CalibrationDoc {
    private final List<CalibrationLine> lines;

    public CalibrationDoc(Collection<String> lines) {
        this(
            lines.stream()
                .map(CalibrationLine::new)
                .collect(Collectors.toList())
        );
    }

    public CalibrationDoc(List<CalibrationLine> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public int value() {
        return lines.stream()
            .map(CalibrationLine::value)
            .mapToInt(Integer::intValue)
            .sum();
    }
}
