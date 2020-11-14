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
    	}else if (checkGuess(words)){    		
    		if(this.model.isFilled()) {
    			this.model.checkResult();
    		} else {
    			this.view.displayWrongNumber();
    			return true;
    		}
    		//WINNER CASE
    		if (this.model.hasWon()) {
    			this.view.displayWin(this.model.getRandomPattern(), this.model.getTurn(), this.model.getInitialTurns());
    			return false;
    		//GAME OVER CASE
    		} else if (this.model.getTurn() <= 0) {
    			this.view.displayGameOver(this.model.getRandomPattern());
    			return false;
    		//CONTINUE PLAYING CASE
    		} else {
    			this.view.displayResults(this.model.getGuessedPatterns(), this.model.getHitsPattern(), this.model.getTurn(), this.model.getInitialTurns());
    		}
    	}
		return true;
	}
	
	public boolean checkGuess(String[] words) {
		int length = this.model.getLENGTH();
		for(int i=1; i<=length; i++) {
			int val;
			try {
				val = Integer.parseInt(words[i]);
			}catch(NumberFormatException e) {
				this.view.displayError();
				return false;
			}
			
			if(val >= 1 && val <= 9) {
				this.model.buildGuessedPattern(val);
			}else {
				this.view.displayWrongNumber();
				return false;
            }
		}
		return true;
	}
}
