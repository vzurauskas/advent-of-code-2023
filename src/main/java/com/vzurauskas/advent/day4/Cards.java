package com.vzurauskas.advent.day4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

    public int totalCards() {
        return cards.size();
    }

    public Cards scratch() {
        for (int i = 0; i < cards.size(); i++) {
            cards.addAll(wonFor(cards.get(i)));
            cards.sort(Comparator.naturalOrder());
        }
        return this;
    }

    private Collection<Card> wonFor(Card card) {
        Collection<Card> won = new ArrayList<>();
        for (int i = card.id() + 1; i <= card.id() + card.matches(); i++) {
            fromInitial(i).map(Card::copy).ifPresent(won::add);
        }
        return won;
    }

    private Optional<Card> fromInitial(int id) {
        return new ArrayList<>(cards).stream()
            .filter(card -> card.id() == id)
            .findAny();
    }
}
