package MasterMind;

import java.util.ArrayList;

public class View {
	int LENGTH = 4;
	public View(int length) {
		this.LENGTH = length;
	}
	
	public void displayHelp() {
		System.out.println("");
		System.out.println("Available commands:");
		System.out.println("guess 1 4 3 8 ... -- make next guess");
		System.out.println("instructions      -- see game instructions");
        System.out.println("reset             -- start a new game");
        System.out.println("quit              -- quit the game");
	}
	
	public void displayInstructions(){
		System.out.println("");
		System.out.println("INSTRUCTIONS");
		System.out.println("You can combine numbers from 1 to 9");
		System.out.println("The combination has " + LENGTH + " numbers");
		System.out.println("White (W)  indicates right number and right position");
		System.out.println("Black (B) indicates right number but wrong position");
		System.out.println("Nothing (X) indicates wrong number");
	}
	
	public void displayResults(ArrayList<Integer>[] guessedPatterns, ArrayList<String>[] resultPattern, int turn, int max) {
	    int length = max-turn;
	    System.out.println("");
	    for(int i = 0; i < length; i++) {
	        System.out.println("Turn " + (i+1) + " :" + guessedPatterns[i] + "  " + resultPattern[i]);
	    }
	    System.out.println("You have " + turn + " turns left");
	}
	
	public void displayGameOver(ArrayList<Integer> randomPattern) {
		System.out.println("");
		System.out.println("You have no turns left!");
		System.out.println("The correct combination was " + randomPattern);
		System.out.println("GAME OVER");
	}
	
	public void displayWin(ArrayList<Integer> randomPattern) {
		System.out.println("");
		System.out.println("Perfect! The correct combination is " + randomPattern);
		System.out.println("You are the winner!");
	}
	
	public void displayWrongNumber() {
		System.out.println("");
		System.out.println("Error: Only allowed numbers from 1 to 9");
		System.out.println("The combination must have " + LENGTH + " numbers");
	}
	
	public void displayError() {
		System.out.println("");
		System.out.println("Error: wrong command");
	}
	
}


