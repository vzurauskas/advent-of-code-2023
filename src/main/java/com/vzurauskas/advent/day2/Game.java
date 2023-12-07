package com.vzurauskas.advent.day2;

public final class Game {
    private final int id;
    private final Handfuls handfuls;

    public Game(String line) {
        this(line.split(":")[0], line.split(": ")[1]);
    }

    private Game(String game, String handfuls) {
        this.id = Integer.parseInt(game.split(" ")[1]);
        this.handfuls = new Handfuls(handfuls);
    }

    public long power() {
        return handfuls.power();
    }

    public boolean isPossible() {
        return handfuls.isPossible();
    }

    public int id() {
        return id;
    }
}
