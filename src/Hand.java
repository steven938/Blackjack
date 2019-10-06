/**
 * The Hand class represents each player's hand.
 * @author StevenChen
 */

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cardList;

    Hand() {
        this.cardList = new ArrayList<Card>();
    }

    // Add a card to a hand
    void addCard(Card c) {
        cardList.add(c);
    }

    // Checks if a hand has Blackjack
    boolean isBlackjack() {
        return (getOptimalValue() == 21);
    }

    // Returns the value closest to 21 such that it does not exceed 21
    int getOptimalValue() {
        if (getValueOneAceAsEleven() > 21) {
            return getMinValue();
        } else {
            return getValueOneAceAsEleven();
        }
    }

    // Get a particular card in the hand
    Card getCard(int i) {
        return cardList.get(i);
    }

    // Get the value of the hand with all Aces counting as 1.
    private int getMinValue() {
        int ret = 0;
        for (Card c : cardList) {
            // Aces count as 1 in this case
            if (c.getVal() == 1) {
                ret += 1;
            } else if (c.getVal() > 10) {
                ret += 10;
            } else {
                ret += c.getVal();
            }
        }
        return ret;
    }

    // Gets the value of the hand, with one Ace counting as 11.
    // Note: You can't have two Aces count for 11 without busting.
    private int getValueOneAceAsEleven() {
        int ret = 0;
        boolean foundOne = false;
        for (Card c: cardList) {
            // Aces count as 11 in this case
            if (c.getVal() == 1) {
                if (foundOne) {
                    ret += 1;
                } else {
                    ret += 11;
                    foundOne = true;
                }
            } else if (c.getVal() > 10) {
                ret += 10;
            } else {
                ret += c.getVal();
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        String ret = "";
        for (Card c : cardList) {
            ret += c.toString() + ", ";
        }
        return ret.replaceAll(", $", "");
    }
}
