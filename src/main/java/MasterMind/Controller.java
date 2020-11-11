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
		return false;
	}
	
	public boolean isPlaying() {
		boolean playing = true;
		if(model.hasWon() || model.getTurn() <= 0) {
			playing = false;
		}
		return playing;
	}
}
