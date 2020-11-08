package MasterMind;

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
	}
	
	public void displayHelp() {
		System.out.println("Available commands:");
		
	}
	
	public void startNewGame() {
		this.displayInstructions();
	}
}


