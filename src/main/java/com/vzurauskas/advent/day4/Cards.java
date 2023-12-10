package com.vzurauskas.advent.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Cards {
    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public int totalPoints() {
        return cards.stream()
            .mapToInt(Card::points)
            .sum();
    }

    public int scratch() {
        List<CardStack> stacks = cards.stream()
            .map(c -> new CardStack(c.id(), 1, c.matches()))
            .collect(Collectors.toList());
        for (int i = 0; i < stacks.size(); i++) {
            CardStack stack = stacks.get(i);
            for (int j = i + 1; j <= i + stack.matches(); j++) {
                stacks.get(j).copy(stack.count());
            }
        }
        return stacks.stream().mapToInt(CardStack::count).sum();
    }

    private static final class CardStack {
        private final int id;
        private int count;
        private final int matches;

        CardStack(int id, int count, int matches) {
            this.id = id;
            this.count = count;
            this.matches = matches;
        }

        public int matches() {
            return matches;
        }

        void copy(int times) {
            count += times;
        }

        public int count() {
            return count;
        }
    }
}
