package ood.blackjack;

import java.util.List;

public class BlackJackHand extends Hand {

    /**
     * 'A' - 1 or 11
     * '2 ~ 10' - 2 ~ 10
     * 'JQK' ~ 10
     * @return the total score of the cards in the hand.
     */
    @Override
    public int score() {
        List<Card> cards = this.getCards();
        // TODO: DFS
        return -1;
    }
}
