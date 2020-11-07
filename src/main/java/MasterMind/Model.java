package MasterMind;

import java.util.ArrayList;
import java.util.Random;

public class Model {
	boolean filled = false;
	boolean victory = false;
	int LENGTH = 0;
	ArrayList<Integer> indices = new ArrayList<Integer>();
	
	public Model(int LENGTH){
		this.LENGTH = LENGTH;
	}
	
	 //Getters
	int getLENGTH() {return LENGTH;}
	ArrayList<Integer> getIndices(){return indices;}
	
	public void generateRandomPattern() {
		for (int i=0; i<LENGTH; i++) {
			Random randomGenerator = new Random();
			if(indices.size() < LENGTH) {
				int randomNumber = randomGenerator.nextInt(7);
				indices.add(randomNumber);
			}
		}
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
