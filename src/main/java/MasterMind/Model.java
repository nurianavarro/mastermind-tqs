package MasterMind;

public class Model {
	boolean filled = false;
	boolean victory = false;
	int turn;
	
	public Model(){
		turn = 9;
	}
	
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
