/*
 * Name: Mark Meyer
 * Class: CYBR 150
 * Project: Custom Blackjack Deck Game
 * File: Player.java
 *
 * Purpose:
 * This class represents a player or dealer in the Blackjack game.
 */

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void clearHand() {
        hand.clear();
    }

    public int getHandValue() {
        int total = 0;
        int aceCount = 0;

        for (Card card : hand) {
            total += card.getValue();

            if (card.isAce()) {
                aceCount++;
            }
        }

        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

    public boolean isBusted() {
        return getHandValue() > 21;
    }

    public void showHand() {
        System.out.println(name + "'s hand:");

        for (Card card : hand) {
            System.out.println("  " + card);
        }

        System.out.println("Total: " + getHandValue());
    }

    public void showDealerFirstCard() {
        System.out.println(name + "'s hand:");
        if (hand.size() > 0) {
            System.out.println("  " + hand.get(0));
            System.out.println("  [Hidden Card]");
        }
    }

    public Card getLastCard() {
        if (hand.size() == 0) {
            return null;
        }

        return hand.get(hand.size() - 1);
    }

    public Card getBestQuoteCard() {
        if (hand.size() == 0) {
            return null;
        }

        for (Card card : hand) {
            if (card.isWild()) {
                return card;
            }
        }

        return hand.get(hand.size() - 1);
    }

    public String getName() {
        return name;
    }
}
