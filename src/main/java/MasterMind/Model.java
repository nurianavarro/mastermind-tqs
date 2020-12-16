package MasterMind;

import java.util.ArrayList;
import java.util.Random;

public class Model {
	private int LENGTH = 0;
	int turn = 0;
	int initialTurns = 10;
	private int countWhite = 0;
	private int countBlack = 0;
	private ArrayList<Integer> randomPattern = new ArrayList<Integer>();
	private ArrayList<Integer> guessedPattern = new ArrayList<Integer>();
	private ArrayList<Integer>[] guessedPatterns = new ArrayList[initialTurns];
	private ArrayList<String>[] hitsPattern = new ArrayList[initialTurns];
	
	public Model(int LENGTH, int turn){
		this.LENGTH = LENGTH;
		countWhite = 0;
		countBlack = 0;
		this.turn = turn;
		this.initialTurns = turn;
		guessedPattern.clear();
		randomPattern.clear();		
		//initializeLists
		this.initializeLists();
		//generate the winner pattern
		this.generateRandomPattern();
	}
	
	public void initializeLists() {
		for (int i=0; i<this.initialTurns; i++) {
			guessedPatterns[i] = new ArrayList<Integer>();
			hitsPattern[i] = new ArrayList<String>();
		}
	}
	
	 //Getters
	int getLENGTH() {return LENGTH;}
	int getTurn() {return turn;}
	int getInitialTurns() {return initialTurns;}
	int getCountW() {return countWhite;}
	int getCountB() {return countBlack;}
	
	ArrayList<Integer> getRandomPattern(){return randomPattern;}
	ArrayList<Integer> getGuessedPattern(){return guessedPattern;}
	ArrayList<Integer>[] getGuessedPatterns(){return guessedPatterns;}
	ArrayList<String>[] getHitsPattern(){return hitsPattern;}
	
	//Setters
	public void setRandomPattern(ArrayList<Integer> randomPattern) {
		this.randomPattern = randomPattern;
	}
	public void setGuessedPattern(ArrayList<Integer> guessedPattern) {
		this.guessedPattern = guessedPattern;
	}
	
	
	public void buildGuessedPattern(int val) {
		this.guessedPattern.add(val);
		int current = this.initialTurns - this.turn;
		this.guessedPatterns[current].add(val);
		this.countWhite = 0;
		this.countBlack = 0;
	}
	
	public void generateRandomPattern() {
		for (int i=0; i<LENGTH; i++) {
			boolean repeatedNumber = true;
			Random randomGenerator = new Random();
			if(randomPattern.size() < LENGTH) {
				while(repeatedNumber) {
					//We want numbers from 1 to 9 -> nextInt(max-min+1)+min
					int randomNumber = randomGenerator.nextInt(9) + 1;
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
					//Correct number and position = W
					hitsPattern[this.initialTurns - this.turn].add("W");
				}else {
					countBlack++;
					//Correct number but wrong position = B
					hitsPattern[this.initialTurns - this.turn].add("B");
				}
			} else {
				//Wrong number = X
				hitsPattern[this.initialTurns - this.turn].add("X");
			}
		}
		
		//Decrement turn
		this.updateTurn();
		//Clear guessedPattern for the next iteration
		this.guessedPattern.clear();
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
		guessedPattern.clear();
		randomPattern.clear();
		turn = initialTurns;
		this.initializeLists();
		
	}
	
	public void resetCountWhite() {
 		countWhite = 0;
 	}
}
