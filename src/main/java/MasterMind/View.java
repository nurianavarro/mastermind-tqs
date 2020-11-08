package MasterMind;

public class View {
	int turn = 0;
	int LENGTH = 4;
	public View(int length, int turns) {
		this.LENGTH = length;
		this.turn = turns;
	}
	
	public void setTurn(int turn) {this.turn = turn;}
	
	public void displayInstructions(){
		System.out.println("INSTRUCTIONS");
		System.out.println("You can combinate numbers from 1 to 9");
		System.out.println("The combination has " + LENGTH + " numbers");
		System.out.println("No duplicates are allowed");
		System.out.println("White indicates right number and right position");
		System.out.println("Black indicates right number but wrong position");
	}
	
	public void startNewGame() {
		this.displayInstructions();
	}
}


