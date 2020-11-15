package MasterMind;

import java.util.ArrayList;

public class MockView extends View {

	public MockView(int length) {
		super(length);
		// TODO Auto-generated constructor stub
	}

	public void displayGameOver() {
		System.out.println("GAME OVER");
	}
	
	public void displayWin() {
		System.out.println("You are the winner!");
	}
	
	public void displayContinuePlaying() {
		System.out.println("Not yet!");
	}
}
