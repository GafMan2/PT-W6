package week06CodingAssignment;

public class Card { // Here I define a class named Card
	
	int value; // int of value represents the numeric value of the card (i.e. 2)
	String name; // String name represents the name of the card (i.e. Two of Diamonds)
	
    public Card(int value, String name) { // This is the constructor for the Card class.
    	                                 // It initializes value and name fields 
        this.value = value;             // when a new Card object is created.
        this.name = name;
    }
    // Here I generated the Getters and Setters methods from the Source dropdown
	public int getValue() { // The getter returns the current value
		return value; 
	} 
	public void setValue(int value) { // The setter allows you to update the value
		this.value = value; 
	}
		public String getName() { // The getter returns the current name
		return name;
	}
	public void setName(String name) { // the setter allows you to update the name
		this.name = name; 
	}
		public void describe() {  // The describe method prints information about the card
        System.out.println("Card: " + name); // This line will print the cards name
        System.out.println("Value: " + value); // This line will print the cards value
    }
		public static void main(String[] args) { // Here is my main method
		    Card myCard = new Card(2, "Two of Diamonds"); // Here I create a card object with a value and name

		    myCard.describe(); // Here I call the describe method to print the card name and value
		}
	}
	
