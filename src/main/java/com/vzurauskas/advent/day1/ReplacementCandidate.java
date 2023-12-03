package com.vzurauskas.advent.day1;

import java.util.Objects;

final class ReplacementCandidate implements Comparable<ReplacementCandidate> {
    private final String line;
    private final String word;
    private final int number;

    ReplacementCandidate(String line, String word, int number) {
        this.line = line;
        this.word = word;
        this.number = number;
    }

    String word() {
        return word;
    }

    String apply() {
        return line.replace(word, String.valueOf(number));
    }

    @Override
    public int compareTo(ReplacementCandidate other) {
        return other.index() - this.index();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReplacementCandidate)) return false;
        final ReplacementCandidate candidate = (ReplacementCandidate) o;
        return number == candidate.number && line.equals(candidate.line) && word.equals(candidate.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, word, number);
    }

    private int index() {
        return line.indexOf(word);
    }
}
