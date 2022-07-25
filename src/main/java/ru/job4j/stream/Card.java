package ru.job4j.stream;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

enum Value {
    V_6, V_7, V_8
}

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }

    public static void main(String[] args) {
        Set<Card> cardDeck = Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(val -> new Card(suit, val)))
                .collect(Collectors.toSet());
        cardDeck.forEach(System.out::println);
    }
}
