Command-line Blackjack game created by Derek Leung.

- To run the game, run the main method in the Main.java file.  Steps:
- javac Main.java
- java Main


Design Document Questions:
- This is an implementation of Blackjack card game.  Aces can count as either 1 or 11.
  However, player cannot split their hand.
- In designing the game, I abstracted the classes at a high level to represent game objects.
    I created a Card class first to represent a playing card, with a suit just for stylistic purposes.
    I used a int value between 1-13 to represent the the face value for simplicity sake.
    I then created a Deck class which stored an ArrayList of Cards and provided simple helper methods to shuffle the
        deck as well as deal the first card off the deck.  It also has a toString for debugging purposes.
    I also created a Hand class which stored each player's hands (both dealer and player) and had methods to compute
        the optimal hand (depending on whether we count Aces as 1 or 11).  It has methods to add cards to the hand for
        dealing purposes.  There are also helper methods to get a particular card in the hand as well as test if the
        hand has Blackjack.
    I used a List, particularly ArrayList for both deck and hand because of their ease of use as well as fast
        addition to the list.  Also, Collections.shuffle made it easy to shuffle the deck.
- I implemented the game in Java because I am most familiar with Java, having been a TA for a heavy-Java programming
    class.  I also feel that Java's OOP-paradigm made the creation and use of Deck, Card, Hand objects more easy than
    some scripting languages.  Java also has many built-in utilities and data structures for use.