package MasterMind;

public class MockModel extends Model {
	boolean filled = false;
	boolean victory = false;
	
	public MockModel(){
		
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
