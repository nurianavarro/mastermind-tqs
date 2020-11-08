package MasterMind;

import java.util.ArrayList;
import java.util.Random;

public class Model {
	boolean filled = false;
	boolean victory = false;
	int LENGTH = 0;
	ArrayList<Integer> randomPattern = new ArrayList<Integer>();
	ArrayList<Integer> guessedPattern = new ArrayList<Integer>();
	
	public Model(int LENGTH){
		this.LENGTH = LENGTH;
	}
	
	 //Getters
	int getLENGTH() {return LENGTH;}
	ArrayList<Integer> getRandomPattern(){return randomPattern;}
	ArrayList<Integer> getGuessedPattern(){return guessedPattern;}
	public void setGuessedPattern(ArrayList<Integer> guessedPattern) {
		this.guessedPattern = guessedPattern;
	}
	public void setRandomPattern(ArrayList<Integer> randomPattern) {
		this.randomPattern = randomPattern;
	}
	
	public void generateRandomPattern() {
		for (int i=0; i<LENGTH; i++) {
			boolean repeatedNumber = true;
			Random randomGenerator = new Random();
			if(randomPattern.size() < LENGTH) {
				while(repeatedNumber) {
					int randomNumber = randomGenerator.nextInt(7);
					if(!randomPattern.contains(randomNumber)) {
						randomPattern.add(randomNumber);
						repeatedNumber = false;
					}
				}	
			}
		}
	}
	
	public void checkResult() {
		
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
