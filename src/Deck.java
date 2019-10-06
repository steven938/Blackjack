/**
 * The Deck class represents a 52-deck of cards.
 * @author StevenChen
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deckOfCards;

    // Constructor for the Deck
    Deck() {
        this.deckOfCards = initialize();
    }

    // Creates a standard deck
    private List<Card> initialize() {
        List<Card> returnDeck = new ArrayList<Card>();
        for (int i = 1; i <= 13; i++) {
            for (Card.Suit s : Card.Suit.values()) {
                returnDeck.add(new Card(i, s));
            }
        }
        return returnDeck;
    }

    // Shuffles the deck
    void shuffle() {
        Collections.shuffle(deckOfCards);
    }

    Card dealCard() {
        return deckOfCards.remove(0);
    }

    // Return the string representation of the cards for easy debugging
    @Override
    public String toString() {
        String ret = "";
        for(Card c : deckOfCards) {
            ret = ret + c.toString() + " / ";
        }
        return ret;
    }
}
