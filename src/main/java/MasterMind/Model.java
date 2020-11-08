package MasterMind;

import java.util.ArrayList;
import java.util.Random;

public class Model {
	boolean filled = false;
	boolean victory = false;
	int LENGTH = 0;
	ArrayList<Integer> randomPattern = new ArrayList<Integer>();
	ArrayList<Integer> guessedPattern = new ArrayList<Integer>();
	int countWhite = 0;
	int countBlack = 0;
	
	public Model(int LENGTH){
		this.LENGTH = LENGTH;
		countWhite = 0;
		countBlack = 0;
	}
	
	 //Getters
	int getLENGTH() {return LENGTH;}
	ArrayList<Integer> getRandomPattern(){return randomPattern;}
	ArrayList<Integer> getGuessedPattern(){return guessedPattern;}
	public void setGuessedPattern(ArrayList<Integer> guessedPattern) {
		this.guessedPattern = guessedPattern;
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
		for(int i=0; i<LENGTH; i++) {
			if(randomPattern.contains(guessedPattern.get(i))) {
				if(randomPattern.get(i)==guessedPattern.get(i)) {
					countWhite++;
				}else {
					countBlack++;
				}
			}
		}
	}
	
	boolean isFilled() {
		return filled;
	}
	
	boolean hasWon(){
		return victory;
	}
	
}
