package com.vzurauskas.advent.day3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Grid {
    private final List<List<Position>> grid;
    private final Set<Symbol> symbols;
    private final Set<Number> numbers;

    public Grid() {
        this.grid = new ArrayList<>();
        this.symbols = new HashSet<>();
        this.numbers = new HashSet<>();
    }

    public Grid fill(List<String> lines) {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            List<Position> row = new ArrayList<>();
            for (int x = 0; x < line.length(); x++) {
                row.add(new Position(x, y, Character.toString(line.charAt(x))));
            }
            grid.add(row);
        }
        return this;
    }

    public Grid enrich() {
        for (int y = 0; y < grid.size(); y++) {
            List<Position> row = grid.get(y);
            for (int x = 0; x < row.size(); x++) {
                Position position = row.get(x);
                if (position.isSymbol()) {
                    Symbol symbol = new Symbol(x, y);
                    position.setElement(symbol);
                    symbols.add(symbol);
                } else if (position.isDigit()) {
                    Number number = numberAt(x, y);
                    position.setElement(number);
                    numbers.add(number);
                }
            }
        }
        return this;
    }

    public Position at(int x, int y) {
        return grid.get(y).get(x);
    }

    public Number numberAt(int x, int y) {
        int start = x;
        while (start > 0 && at(start - 1, y).isDigit()) {
            start--;
        }
        String number = at(start, y).literal();
        int i = start + 1;
        while (at(i, y).isDigit()) {
            number += at(i, y).literal();
            i++;
        }
        return new Number(start, y, Integer.parseInt(number));
    }
}
