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
		int length = this.model.getLENGTH();
		String line = input.nextLine();
		String[] words = line.split("\\s+");
		if(words.length > 0) {
			if (words[0].equals("quit")) {
                return false;
            } else if (words[0].equals("reset")) {
                this.model.resetGuessedPattern();
            } else if (words[0].equals("instructions")) {
                this.view.displayInstructions();
            } else if (words[0].equals("guess")) {
            	
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
}
