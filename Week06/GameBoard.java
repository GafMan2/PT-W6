package Week06;

import java.util.Arrays;

public class GameBoard {
	

		String[] board = new String[9];
		
		public void initialize() {
			for (int i = 1; i <=9; i++){
				this.board[i-1] = String.valueOf(i);
				
			}
	}
		public void display() {
			
			System.out.println("     +---+---+---+");
			System.out.println("     | " + this.board[0] + " | " + this.board[1] + " | " + this.board[2] + " | ");
			System.out.println("     +---+---+---+");
			System.out.println("     | " + this.board[3] + " | " + this.board[4] + " | " + this.board[5] + " | ");
			System.out.println("     +---+---+---+");
			System.out.println("     | " + this.board[6] + " | " + this.board[7] + " | " + this.board[8] + " | ");
			System.out.println("     +---+---+---+");
		}

	public static void main(String[] args) {


	}
	public boolean ifValidSetSquare(int squareNumber, String readInput, String player) {
		if (this.board [squareNumber-1].equals (readInput)) {
			this.board[squareNumber-1] = player;
			return true;
		} else {
			return false;
		}
 	}
	public String checkWinStatus() {
		for(int pos = 0; pos < 8; pos++) {
			String winningCombo = "";
			
			switch (pos) {
			case 0:
				winningCombo = this.board[0] + this.board[1] + this.board[2];
				break;
			case 1:
				winningCombo = this.board[3] + this.board[4] + this.board[5];
				break;
			case 2:
				winningCombo = this.board[6] + this.board[7] + this.board[8];
				break;
			case 3:
				winningCombo = this.board[0] + this.board[3] + this.board[6];
				break;
			case 4:
				winningCombo = this.board[1] + this.board[4] + this.board[7];
				break;
			case 5:
				winningCombo = this.board[2] + this.board[5] + this.board[8];
				break;
			case 6:
				winningCombo = this.board[0] + this.board[4] + this.board[8];
				break;
			case 7:
				winningCombo = this.board[2] + this.board[4] + this.board[6];
				break;
			}
			
			if(winningCombo.equals("XXX")) {
				return "X";
			} else if (winningCombo.equals("OOO")) {
				return "O";
				
			}
		}
		for(int pos = 1; pos <= 9; pos++) {
			if (Arrays.asList(this.board).contains(String.valueOf(pos))) {
				break;
			} else if (pos == 9) {
				return "draw";
			}
		}
		return "";
	}

	}



