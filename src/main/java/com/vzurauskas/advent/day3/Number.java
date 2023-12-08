package com.vzurauskas.advent.day3;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public final class Number implements Element {
    private final int startX;
    private final int startY;
    private final int value;

    public Number(int startX, int startY, int value) {
        this.startX = startX;
        this.startY = startY;
        this.value = value;
    }

    @Override
    public int value() {
        return value;
    }

    @Override
    public Set<? extends Element> children() {
        return Collections.emptySet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        final Number number = (Number) o;
        return startX == number.startX && startY == number.startY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startX, startY);
    }
}
