package ood.blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public abstract int score();

    public List<Card> getCards() {
        return this.cards;
    }
}
