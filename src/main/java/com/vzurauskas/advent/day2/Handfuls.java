package com.vzurauskas.advent.day2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Handfuls {
    private final List<Handful> handfuls;

    public Handfuls(String handfuls) {
        this.handfuls = Arrays.stream(handfuls.split("; "))
            .map(Handful::new)
            .collect(Collectors.toList());
    }

    public long power() {
        return (long) maxRed() * (long) maxGreen() * (long) maxBlue();
    }

    private int maxRed() {
        return handfuls.stream()
            .map(Handful::red)
            .max(Comparator.naturalOrder())
            .orElse(0);
    }

    private int maxGreen() {
        return handfuls.stream()
            .map(Handful::green)
            .max(Comparator.naturalOrder())
            .orElse(0);
    }

    private int maxBlue() {
        return handfuls.stream()
            .map(Handful::blue)
            .max(Comparator.naturalOrder())
            .orElse(0);
    }

    public boolean isPossible() {
        return handfuls.stream().allMatch(Handfuls.Handful::isPossible);
    }

    public static final class Handful {
        private final Map<String, Integer> cubes;

        public Handful(String handful) {
            cubes = new HashMap<>();
            Arrays.stream(handful.split(", ")).forEach(same -> {
                cubes.put(same.split(" ")[1], Integer.parseInt(same.split(" ")[0]));
            });
        }

        int red() {
            return cubes.getOrDefault("red", 0);
        }

        int green() {
            return cubes.getOrDefault("green", 0);
        }

        int blue() {
            return cubes.getOrDefault("blue", 0);
        }

        public boolean isPossible() {
            return red() <= 12
                && green() <= 13
                && blue() <= 14;
        }
    }
}
