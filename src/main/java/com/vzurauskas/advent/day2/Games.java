package com.vzurauskas.advent.day2;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class Games {
    private final List<Game> games;

    public Games(Collection<String> lines) {
        this.games = lines.stream()
            .map(Game::new)
            .collect(Collectors.toList());
    }

    public int possibles() {
        return games.stream()
            .filter(Game::isPossible)
            .map(Game::id)
            .mapToInt(Integer::intValue)
            .sum();
    }

    public long power() {
        return games.stream()
            .mapToLong(Game::power)
            .sum();
    }
}
