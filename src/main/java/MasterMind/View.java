package MasterMind;

import java.util.ArrayList;

public class View {
	int turn = 0;
	int LENGTH = 4;
	public View(int length, int turns) {
		this.LENGTH = length;
		this.turn = turns;
	}
	
	int getTurn() {return turn;}
	public void setTurn(int turn) {this.turn = turn;}
	
	public void displayInstructions(){
		System.out.println("INSTRUCTIONS");
		System.out.println("You can combine numbers from 1 to 9");
		System.out.println("The combination has " + LENGTH + " numbers");
		System.out.println("No duplicates are allowed");
		System.out.println("White (W)  indicates right number and right position");
		System.out.println("Black (B) indicates right number but wrong position");
		System.out.println("Nothing (X) indicates wrong number");
	}
	
	public void displayHelp() {
		System.out.println("Available commands:");
		System.out.println("guess 1 4 3 8 ... -- make next guess");
		System.out.println("instructions      -- see game instructions");
        System.out.println("reset             -- start a new game");
        System.out.println("quit              -- quit the game");
	}
	
	
	public void startNewGame() {
		//this.displayInstructions();
	}
}


