package week06CodingAssignment;

public class App { // Here I created a class named App
	
	public static void main(String[] args) {
        // a) Instantiate a Deck and two Players, call the shuffle method on the deck.
        Deck gameDeck = new Deck(); // Deck is instantiated
        Player player1 = new Player("Janice"); // a player named Janice is instantiated
        Player player2 = new Player("John"); // a player named John is instantiated

        gameDeck.shuffle(); // the new deck is shuffled

        // b) Using a traditional for loop, iterate 52 times calling the Draw method on the other player each iteration using the Deck you instantiated.
        for (int i = 0; i < 52; i++) { // a for loop iterates 52x, each iteration represents a draw from the deck
            if (i % 2 == 0) {
                player1.draw(gameDeck);
            } else {
                player2.draw(gameDeck);
            }
        }
        
        // c) Using a traditional for loop, iterate 26 times and call the flip method for each player.
        for (int i = 0; i < 26; i++) { // another for loop iterates 26x, representing each player flipping a card
            System.out.println("\nTurn " + (i + 1) + ":");

            Card card1 = player1.flip();
            Card card2 = player2.flip();

            // a) Using the Card describe() method when each card is flipped illustrates the game play.
            System.out.println("Janice flips: ");
            if (card1 != null) {
                card1.describe();
            }

            System.out.println("John flips: ");
            if (card2 != null) {
                card2.describe();
            }

            // b) Printing the winner of each turn adds interest.
            if (card1 != null && card2 != null) {
                if (card1.getValue() > card2.getValue()) {
                    player1.incrementScore();
                    System.out.println("Janice wins this turn!");
                } else if (card1.getValue() < card2.getValue()) {
                    player2.incrementScore();
                    System.out.println("John wins this turn!");
                } else {
                    System.out.println("It's a draw this turn!");
                }
            }

        // c) Printing the updated score after each turn shows game progression.
        System.out.println("Janice Score: " + player1.getScore());
        System.out.println("John Score: " + player2.getScore());
            
         }
        // d) Print the final scores and determine the overall winner.
        
        // After all turns are completed, the final scores for each player are displayed 
        // and the name of the winner or draw is displayed
        
        System.out.println("\n+----+----+----+----+");
        System.out.println("    Final Scores:");
        System.out.println("+----+----+----+----+");
        System.out.println("  Janice Score: " + player1.getScore());
        System.out.println("  John Score: " + player2.getScore());

        if (player1.getScore() > player2.getScore()) {
        	System.out.println("+----+----+----+----+");
            System.out.println(" Janice wins the game!");
        } else if (player1.getScore() < player2.getScore()) {
        	System.out.println("+----+----+----+----+");
            System.out.println(" John wins the game!");
        } else {
        	System.out.println("+----+----+----+----+");
            System.out.println(" The game is a draw!");
        }
    }
}

