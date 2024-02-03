package week06CodingAssignment;

import java.util.ArrayList;
import java.util.List;

public class Player { // Here I define a class named Player
	
	private List<Card> hand; // I created a List of Card that will hold the cards in the player's hand
    private int score; // I declare an int of score that will store the player's score
    private String name; // I created a String name that will store the player's name

public Player(String name) { // The constructor initializes a player
    this.name = name; // with a given name
    this.score = 0; // sets the initial score to 0
    this.hand = new ArrayList<>(); // and creates an empty hand
}

public void describe() { // The describe method 
    System.out.println("Player: " + name); // prints the player's name
    System.out.println("Score: " + score); // their score 
    System.out.println("Hand:"); // and the cards in their hand

    if (hand.isEmpty()) {
        System.out.println("  (Empty)");
    } else {
        for (Card card : hand) {
            System.out.println("  " + card.getName() + " - Value: " + card.getValue());
        }
    }
}

public Card flip() { // The flip method takes a drawn card, removes it from the deck and flips it over
    if (hand.isEmpty()) { // this if statement checks if their hand is empty
    return null;
    }
    Card flippedCard = hand.remove(0);
    incrementScore(); // this increments the player's score before it returns the flipped card
    return flippedCard;
}

public void draw(Deck deck) { // The draw method is called from the Deck class
    Card drawnCard = deck.draw(); // it draws a card from the deck 
    if (drawnCard != null) { // this if statement checks to see if there was a card to draw from the deck
        hand.add(drawnCard); // and places that card in the player's hand
    }
}

public void incrementScore() { // the incrementScore method adds a 1 to the player's score field
    score++;
}

public static void main(String[] args) { // This is the main method
    Player player1 = new Player("Janice"); // Here I created a player Janice
    Player player2 = new Player("John"); // Here I created a player John
    Deck gameDeck = new Deck(); // Here I created a gameDeck which is a new deck of cards for the game

    while (!gameDeck.isEmpty()) { // this while loop continues as long as the gameDeck is not empty
        player1.draw(gameDeck); // inside the loop each player draws a card 
        player2.draw(gameDeck);

        player1.describe(); // describe shows the card they have
        player2.describe();

        Card flippedCard1 = player1.flip(); //flip flips the card and stores it in the value
        Card flippedCard2 = player2.flip();

        System.out.println("New Turn");

        if (flippedCard1 == null && flippedCard2 == null) { // these if statements check for empty hands
            break; // if both players fail to draw a card this break terminates the loop
        }

        System.out.println("Janice flipped:"); 
        if (flippedCard1 != null) {
            flippedCard1.describe(); // this describe displays Janice's flipped card
        }

        System.out.println("John flipped:");
        if (flippedCard2 != null) {
            flippedCard2.describe(); // this describe displays John's flipped card
        }

        if (flippedCard1 != null && flippedCard2 != null) { // If both flipped cards are not null 
            if (flippedCard1.getValue() > flippedCard2.getValue()) { // based on the comparison of their values
                player1.incrementScore(); // the scores are incremented
            } else if (flippedCard1.getValue() < flippedCard2.getValue()) {
                player2.incrementScore();
            }
        }
    }
    // After the loop, the final scores are printed, and the winner is declared
    
    System.out.println("+----+----+----+----+");
    System.out.println("  Final Scores:");
    System.out.println("+----+----+----+----+");
    System.out.println("  Janice: " + player1.getScore());
    System.out.println("    John: " + player2.getScore());
    System.out.println("+----+----+----+----+");;

    if (player1.getScore() > player2.getScore()) {
        System.out.println("Janice wins the game!");
        System.out.println("+----+----+----+----+");;
    } else if (player1.getScore() < player2.getScore()) {
        System.out.println("John wins the game!");
        System.out.println("+----+----+----+----+");;
    }
}
public int getScore() { // The getScore method retrieves and returns the player's score.

	return score;
}
}