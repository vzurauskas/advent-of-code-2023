package com.vzurauskas.advent.day3;

import java.util.ArrayList;
import java.util.Collection;

public final class Position {
    private final int x;
    private final int y;
    private final String literal;
    private final Collection<Element> e;

    public Position(int x, int y, String literal) {
        this.x = x;
        this.y = y;
        this.literal = literal;
        this.e = new ArrayList<>();
    }

    public String literal() {
        return literal;
    }

    public boolean isDigit() {
        return literal.matches("-?\\d");
    }

    public boolean isEmpty() {
        return literal.equals(".");
    }

    public boolean isSymbol() {
        return !isEmpty() && !isDigit();
    }

    public void setElement(Element e) {
        this.e.clear();
        this.e.add(e);
    }
}
