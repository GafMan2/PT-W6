package week06CodingAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck { // Here I created a class called Deck that represents a deck of playing cards
	
	List<Card> cards;  // Here I initialize a list that will contain the cards in the deck

    public Deck() { // This is the constructor for the Deck class
        cards = new ArrayList<>();
        initializeDeck(); // This initializes the cards field by calling the method initializeDeck
    }
    
    private void initializeDeck() { // This method populates the deck with the standard 52 cards 
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) { // using a for loop it iterates through suits and values.
            for (int value = 2; value <= 14; value++) {
                String name = getValueName(value) + " of " + suit;
                Card card = new Card(value, name);
                cards.add(card); // a card object is created for each combination and is added to the card list
            }
        }
    }
    public void shuffle() {  // Here I called the shuffle method 
        Collections.shuffle(cards); // it shuffles the deck and randomizes the order of the cards
    }

    public Card draw() {  // Here I called the draw method, it draws, removes and returns the top card from the deck
        if (cards.isEmpty()) { // It checks if the deck is empty
        return null;
        }
        return cards.remove(0);
    }
    
    private String getValueName(int value) { 
        switch (value) { // This method converts the numeric value of a card 
            case 11:    // to its corresponding name
                return "Jack"; // and returns it's suit
            case 12:
                return "Queen";
            case 13:
                return "King";
            case 14:
                return "Ace";
            default:
                return String.valueOf(value);
        }
    }
    
    public static void main(String[] args) { // This is the main method
        Deck myDeck = new Deck(); // Here I created an instance of the Deck class myDeck
        myDeck.shuffle(); // and the shuffle method randomizes the cards in the deck

        while (!myDeck.isEmpty()) { // using a while loop 
            Card drawnCard = myDeck.draw(); // the draw method draws a card from the top of the deck
            if (drawnCard != null) { // If a card is drawn
                System.out.println("Drew a card:"); // This line prints what card and value were drawn
                drawnCard.describe(); // The describe method from the Card class provides the name and value
       
            }
        }
        if (myDeck.isEmpty()) { // The isEmpty method checks to see if the deck is empty 
            System.out.println("There are no more cards left in the deck"); // If so, it prints this 
        }
    }
 
	public boolean isEmpty() { 
		
		return cards.isEmpty();
	}
}
