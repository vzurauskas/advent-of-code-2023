package com.vzurauskas.advent.day1;

import java.util.Map;
import java.util.stream.Stream;

public final class CalibrationLine {
    private static final Map<String, Integer> wordToNumberMap = Map.of(
        "zero", 0,
        "one", 1,
        "two", 2,
        "three", 3,
        "four", 4,
        "five", 5,
        "six", 6,
        "seven", 7,
        "eight", 8,
        "nine", 9
    );
    private final String line;
    private final First first;
    private final Last last;

    public CalibrationLine(String line) {
        this.line = line;
        this.first = new First();
        this.last = new Last();
    }

    public int value() {
        Stream.of(
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        ).forEach(number -> {
            if (line.contains(number)) {
                first.propose(line.indexOf(number), number);
                last.propose(line.lastIndexOf(number), number);
            }
        });
        return Integer.parseInt(first.number() + last.number());
    }

    private final class First {
        private int position = Integer.MAX_VALUE;
        private String number;

        void propose(int position, String number) {
            if (position < this.position) {
                this.position = position;
                this.number = number;
            }
        }

        public String number() {
            return String.valueOf(toInt(number));
        }
    }

    private final class Last {
        private int position = Integer.MIN_VALUE;
        private String number;

        void propose(int position, String number) {
            if (position > this.position) {
                this.position = position;
                this.number = number;
            }
        }

        public String number() {
            return String.valueOf(toInt(number));
        }
    }

    private int toInt(String number) {
        if (number.matches("-?\\d+")) {
            return Integer.parseInt(number);
        } else {
            return wordToNumberMap.get(number);
        }
    }
}
