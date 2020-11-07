package MasterMind;

public class MockModel extends Model {
	public MockModel(int LENGTH) {
		super(LENGTH);
	}

	int LENGTH = 0;
	
	
	public void generateRandomPattern() {
		
	}
	
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
