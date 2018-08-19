package ood.blackjack;

public class Card {
    enum Suit {
        Club, Diamond, Heart, Spade;
    }
    private final String val;
    private final Suit suit;

    public Card(String val, Suit suit) {
        this.val = val;
        this.suit = suit;
    }
}
