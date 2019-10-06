/**
 * The Card class represents a playing card.
 * @author StevenChen
 */

public class Card {

    // Define some static constants for int representations
    public final static int ACE = 1, JACK = 11, QUEEN = 12, KING = 13;

    // Define the four suits
    enum Suit
    {
        SPADE, CLUB, DIAMOND, HEART;
    }

    private int val;
    private Suit suit;

    // Constructing the card
    Card(int faceValue, Suit suit) {
        this.val = faceValue;
        this.suit = suit;
    }

    // Returns the int representation of the face value
    int getVal() {
        return val;
    }

    @Override
    public String toString() {
        String name;
        switch(val) {
            case 1: name = "ACE";
                    break;
            case 11: name = "JACK";
                    break;
            case 12: name = "QUEEN";
                    break;
            case 13: name = "KING";
                    break;
            default: name = "" + val;
                    break;
        }

        String retSuit = "";
        switch(suit) {
            case SPADE: retSuit = "SPADES";
                        break;
            case CLUB: retSuit = "CLUBS";
                        break;
            case DIAMOND: retSuit = "DIAMONDS";
                        break;
            case HEART: retSuit = "HEARTS";
                        break;
        }
        return "[ " + name + " OF " + retSuit + " ]";
    }
}
