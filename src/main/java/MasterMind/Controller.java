package MasterMind;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	View view;
	Model model;
	
	public Controller(View v, Model m){
		view = v;
		model = m;
	}

	public void newGame() {
		model.generateRandomPattern();
		model.resetGuessedPattern();
	}
	
	public boolean loop(Scanner input) {
		this.view.displayHelp();
		String line = input.nextLine();
		String[] words = line.split("\\s+");
		if(words.length > 0) {
			//Option QUIT
			if (words[0].equals("quit")) {
                return false;
                
            //Option RESET
            } else if (words[0].equals("reset")) {
                this.model.resetGuessedPattern();
                
            //Option INSTRUCTIONS
            } else if (words[0].equals("instructions")) {
                this.view.displayInstructions();
                
            //Option GUESS
            } else if (words[0].equals("guess")) {
            	return this.makeGuess(words);    
            	
            //Wrong option
            } else {
            	this.view.displayError();
            }
		} else {
			this.view.displayError();
		}

		return true;
	}
	
	public boolean isPlaying() {
		boolean playing = true;
		if(model.hasWon() || model.getTurn() <= 0) {
			playing = false;
		}
		return playing;
	}
	
	public boolean makeGuess(String[] words) {
		int length = this.model.getLENGTH();
    	if(words.length != length + 1) {
    		this.view.displayWrongNumber();
    		System.out.println("length");
    	}else {
    		for(int i=1; i<=length; i++) {
    			int val;
    			try {
    				val = Integer.parseInt(words[i]);
    			}catch(NumberFormatException e) {
    				this.view.displayError();
    				return true;
    			}
    			if(val >= 1 && val <= 9) {
    				this.model.buildGuessedPattern(val);
    			}else {
    				System.out.println("number");
    				this.view.displayWrongNumber();
    				return true;
                }
    		}
    		
    		if(this.model.isFilled()) {
    			this.model.checkResult();
    		} else {
    			System.out.println("filled");
    			this.view.displayWrongNumber();
    			return true;
    		}
    		
    		
    		if (this.model.hasWon()) {
    			this.view.displayWin(this.model.getRandomPattern());
    			return false;
    		} else if (this.model.getTurn() <= 0) {
    			this.view.displayGameOver(this.model.getRandomPattern());
    			return false;
    		} else {
    			//Display board
    			this.view.displayResults(this.model.getGuessedPatterns(), this.model.getHitsPattern(), this.model.getTurn(), this.model.getInitialTurns());
    		}
    		
    	
    	}
		
		return true;
	}
}
