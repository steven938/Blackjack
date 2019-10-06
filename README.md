# Blackjack Design Document
Instructions for running game:
1. Open terminal or command line tool
2. Navigate to src folder of the game
3. Enter in command line ```javac Main.java```
4. Enter in command line ```java Main```

### Game rules
In this game of Blackjack, normal rules apply. Aces can count as either 1 or 11. Players cannot split their hand.
### Design Choices
I went for a simple to understand and easy to maintain design by using object-oriented principles to define 3 classes: Card, Hand, Deck to represent the game objects.
- The Card class represents playing card with a suit for stylistic representation
    - integer values between 1-13 represent the face value of the card
- The Deck class contains an ArrayList of Cards and helper methods to shuffle and deal cards from teh deck
    - a toString method is used for debugging
- The Hand class represents the player's and dealer's hand and has methods to compute the optimal hand (whether the Ace is a 1 or 11)
    - also contains methods to access particular card in the hand and test if hand is a BlackJack (21)
- The ArrayList data structure is used in both deck and hand because it quickly allows fast dynamic additions to the list and retrievals of elements. As well, it allowed me to use the Collections.shuffle method.
### Language Choice
I chose Java because of its strong Object Oriented Paradigm which made sense to me because a game of black jack is very object oriented. Also, Java has man built-in tools and data structures such as array shuffling. Finally, java is a language I'm very comfortable using.