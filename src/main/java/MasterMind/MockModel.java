package MasterMind;

import java.util.ArrayList;

public class MockModel extends Model {
	String[] correctGuesses = new String[LENGTH];
	int countW = 0;
	int countB = 0;
	
	public MockModel(int LENGTH) {
		super(LENGTH);
	}

	String[] getCorrentGuesses() {return correctGuesses;}
	int getCountW() {return countW;}
	
	boolean isFilled() {
		return filled;
	}
	
	boolean hasWon(){
		return victory;
	}
	
	boolean checkIfContains() {
		return true;
	}
	
	
}
