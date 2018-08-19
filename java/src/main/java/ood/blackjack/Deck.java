package ood.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;
    private int pivot = 0; // The cards on the left hand of pivot(exclusive) are used.

    public Deck() {
        this.cards = new ArrayList<Card>(52);
        List<Card.Suit> suits = new ArrayList<>();
        suits.add(Card.Suit.Club);
        suits.add(Card.Suit.Diamond);
        suits.add(Card.Suit.Heart);
        suits.add(Card.Suit.Spade);
        for (Card.Suit suit : suits) {
            cards.add(new Card("A", suit));
            cards.add(new Card("2", suit));
            cards.add(new Card("3", suit));
            cards.add(new Card("4", suit));
            cards.add(new Card("5", suit));
            cards.add(new Card("6", suit));
            cards.add(new Card("7", suit));
            cards.add(new Card("8", suit));
            cards.add(new Card("9", suit));
            cards.add(new Card("10", suit));
            cards.add(new Card("J", suit));
            cards.add(new Card("Q", suit));
            cards.add(new Card("K", suit));
        }
        this.shuffle();
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 51; i >= 0; i--) {
            int random = rand.nextInt(i + 1);
            Card temp = cards.get(random);
            cards.set(random, cards.get(i));
            cards.set(i, temp);
        }
        pivot = 0; // collect all cards.
    }

    public Card deal() {
        if (pivot >= 52) {
            return null; // no cards in the deck.
        }
        pivot++;
        return cards.get(pivot - 1);
    }
}
