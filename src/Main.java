/**
 * The Main class runs the Blackjack game.
 * @author StevenChen
 */

import java.util.Scanner;

public class Main {

    private static int money;
    private static int bet;

    public static void main(String[] args) {
        money = 100;
        bet = -1;
        Scanner scanner = new Scanner(System.in);

        welcomeMessage();

        // While the game is still playing, we keep prompting the player
        while (true) {
            // Prompt betting amount
            do {
                System.out.println("How much would you like to bet?");
                try {
                    bet = Integer.parseInt(scanner.next());
                    if (bet < 0 || bet > money) {
                        System.out.println("You have to bet a number between 0 and " + money + ".\n");
                    }
                } catch (Exception e) {
                    System.out.println("Please bet a valid number.\n");
                }
            } while (bet < 0 || bet > money);
            System.out.println("You are betting $" + bet + " .\n");

            // Play the game and obtain the result from one iteration (result represents if the player won)
            boolean result = startGame();

            // Adjust the payoffs appropriately
            if (result) {
                money += bet;
            } else {
                money -= bet;
            }

            // Player runs out of money
            if (money <= 0) {
                System.out.println("You are out of money!  Please play again.");
                break;
            }

            System.out.println("Would you like to quit? [Y]es to quit. Anything else to continue.");
            String action = scanner.next().toLowerCase();

            // Prompt exit from the user
            if (action.equals("y") || action.equals("yes")) {
                System.out.println("You leave the game with $" + money + ".");
                quitOperation();
            }
        }
    }

    private static boolean startGame() {
        Scanner scanner = new Scanner(System.in);

        Deck currDeck = new Deck();
        Hand dealer = new Hand();
        Hand player = new Hand();

        // Shuffles the deck and gives each player two cards
        currDeck.shuffle();
        dealer.addCard(currDeck.dealCard());
        player.addCard(currDeck.dealCard());
        dealer.addCard(currDeck.dealCard());
        player.addCard(currDeck.dealCard());

        System.out.println("\n\n----- Dealer shuffles, deals, and shows one card -----");

        // Dealer shows one card.
        System.out.println("Dealer shows " + dealer.getCard(0) + ".");

        // Check if the dealer has Blackjack.
        if (dealer.isBlackjack()) {
            System.out.println("Dealer has " + dealer.toString() + ".");
            System.out.println("Dealer has Blackjack!  You lost " + bet + ".\n");
            return false;
        }

        // Check if the player has Blackjack.
        if (player.isBlackjack()) {
            System.out.println("Player has " + player.toString() + ".");
            System.out.println("You have Blackjack!  You won " + bet + ".\n");
            return true;
        }

        // Now we prompt the user if they want to hit/stand.
        System.out.println("\n\n----- Player's Turn -----");
        while (true) {
            System.out.println("You have " + player.toString() + ". \n");

            System.out.println("Would you like to [H]it or [S]tand?");
            String action;
            do {
                action = scanner.next().toLowerCase();
                if (!action.equals("h") && !action.equals("hit") && !action.equals("s") && !action.equals("stand")) {
                    System.out.println("Please enter [H]it or [S]tand.");
                }
            } while (!action.equals("h") && !action.equals("hit") && !action.equals("s") && !action.equals("stand"));

            if (action.equals("s") || action.equals("stand")) {
                break;
            } else {
                player.addCard(currDeck.dealCard());
                if (player.getOptimalValue() > 21) {
                    System.out.println("You have " + player.toString() + ". \n");
                    System.out.println("You busted since " + player.getOptimalValue() + " is greater than 21.");
                    System.out.println("Dealer's other card was " + dealer.getCard(1));
                    return false;
                }
            }
        }

        // The dealer has to draw until his total is greater than 16.
        System.out.println("\n\n----- Dealer's Turn -----");
        while (dealer.getOptimalValue() <= 16) {
            Card newCard = currDeck.dealCard();
            dealer.addCard(newCard);
            System.out.println("Dealer hit and got " + newCard + ".");
            if (dealer.getOptimalValue() > 21) {
                System.out.println("Dealer has " + dealer.toString() + ". \n");
                System.out.println("Dealer has busted since " + dealer.getOptimalValue() + " is greater than 21.");
                return true;
            }
        }

        // Compare values between player and dealer
        System.out.println("\n\n----- Comparing Hands -----");
        System.out.println("Player has " + player.toString() + ".");
        System.out.println("Player has Blackjack value " + player.getOptimalValue() + ".\n");

        System.out.println("Dealer has " + dealer.toString() + ".");
        System.out.println("Dealer has Blackjack value " + dealer.getOptimalValue() + ".\n");

        if (dealer.getOptimalValue() == player.getOptimalValue()) {
            System.out.println("Dealer wins on tie.  You lost " + bet + ".\n");
            return false;
        } else if (dealer.getOptimalValue() > player.getOptimalValue()) {
            System.out.println("Dealer has a better hand.  You lost " + bet + ".\n");
            return false;
        } else if (dealer.getOptimalValue() < player.getOptimalValue()) {
            System.out.println("You have a better hand.  You won " + bet + ".\n");
            return true;
        }
        return false;
    }

    private static void welcomeMessage() {
        System.out.println("Welcome to Blackjack!");
        System.out.println("You start out with $100.");
        System.out.println("Good luck!\n");
    }

    private static void quitOperation() {
        System.out.println("Thanks for playing!");
        System.exit(0);
    }
}
