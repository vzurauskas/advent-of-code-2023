package com.vzurauskas.advent.day3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

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
                    Symbol symbol = new Symbol(x, y, this);
                    position.setElement(symbol);
                    symbols.add(symbol);
                } else if (position.isDigit()) {
                    Number number = numberAt(x, y).get();
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

    public Optional<Number> numberAt(int x, int y) {
        if (!at(x, y).isDigit()) {
            return Optional.empty();
        }
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
        return Optional.of(new Number(start, y, Integer.parseInt(number)));
    }

    public Set<? extends Element> numbersAround(int x, int y) {
        HashSet<Number> numbers = new HashSet<>();
        numberAt(x - 1, y).ifPresent(numbers::add);
        numberAt(x - 1, y + 1).ifPresent(numbers::add);
        numberAt(x, y + 1).ifPresent(numbers::add);
        numberAt(x + 1, y + 1).ifPresent(numbers::add);
        numberAt(x + 1, y).ifPresent(numbers::add);
        numberAt(x + 1, y - 1).ifPresent(numbers::add);
        numberAt(x, y - 1).ifPresent(numbers::add);
        numberAt(x - 1, y - 1).ifPresent(numbers::add);
        return numbers;
    }

    public int sumOfNumbers() {
        return symbols.stream()
            .flatMap(symbol -> symbol.children().stream())
            .mapToInt(Element::value)
            .sum();
    }
}
