package MasterMind;

import java.util.ArrayList;
import java.util.Random;

public class Model {
	private int LENGTH = 0;
	private ArrayList<Integer> randomPattern = new ArrayList<Integer>();
	private ArrayList<Integer> guessedPattern = new ArrayList<Integer>();
	private int countWhite = 0;
	private int countBlack = 0;
	int turn;
	int initialTurns;
	
	public Model(int LENGTH, int turn){
		this.LENGTH = LENGTH;
		countWhite = 0;
		countBlack = 0;
		this.turn = turn;
		this.initialTurns = turn;
	}
	
	 //Getters
	int getLENGTH() {return LENGTH;}
	int getTurn() {return turn;}
	ArrayList<Integer> getRandomPattern(){return randomPattern;}
	ArrayList<Integer> getGuessedPattern(){return guessedPattern;}
	int getCountW() {return countWhite;}
	int getCountB() {return countBlack;}
	public void setRandomPattern(ArrayList<Integer> randomPattern) {
		this.randomPattern = randomPattern;
	}
	public void setGuessedPattern(ArrayList<Integer> guessedPattern) {
		this.guessedPattern = guessedPattern;
	}
	
	public void generateRandomPattern() {
		for (int i=0; i<LENGTH; i++) {
			boolean repeatedNumber = true;
			Random randomGenerator = new Random();
			if(randomPattern.size() < LENGTH) {
				while(repeatedNumber) {
					int randomNumber = randomGenerator.nextInt(10);
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
		if(guessedPattern.size() == LENGTH) {
			return true;
		}else {
			return false;
		}	
	}
	
	boolean hasWon(){
		if(countWhite == LENGTH) {
			return true;
		}else {
			return false;
		}
	}
	
	public void updateTurn() {
		this.turn--;
	}
	
	public void resetGuessedPattern(){
		countWhite = 0;
		countBlack = 0;
	}
	
}
