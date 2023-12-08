package com.vzurauskas.advent.day3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Symbol implements Element {
    private final int x;
    private final int y;
    private final Set<Number> numbers;

    public Symbol(int x, int y) {
        this.x = x;
        this.y = y;
        this.numbers = new HashSet<>();
    }

    @Override
    public int value() {
        return 0;
    }

    @Override
    public Iterable<Element> children() {
        return new ArrayList<>(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Symbol)) return false;
        final Symbol symbol = (Symbol) o;
        return x == symbol.x && y == symbol.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
