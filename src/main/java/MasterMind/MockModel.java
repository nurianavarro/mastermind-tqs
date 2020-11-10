package MasterMind;

import java.util.ArrayList;

public class MockModel extends Model {
	
	public MockModel(int LENGTH, int turn) {
		super(LENGTH, turn);
	}

	boolean hasWon() {
		return true;
	}
	
	boolean isFilled() {
		return true;
	}
	
	
	
	
	
}
