package MasterMind;

import java.util.ArrayList;

public class MockModel extends Model {
	
	
	public MockModel(int LENGTH) {
		super(LENGTH);
	}

	int getCountW() {return countWhite;}
	public void setRandomPattern(ArrayList<Integer> randomPattern) {
		this.randomPattern = randomPattern;
	}
	
	boolean isFilled() {
		return true;
	}
	
	
	
}
