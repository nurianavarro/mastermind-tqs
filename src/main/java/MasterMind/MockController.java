package MasterMind;

import java.util.Scanner;

public class MockController extends Controller{
	View view;
	Model model;
	
	
	public MockController(View v, Model m){
		super(v,m);
		model = m;
		view = v;
	}
	
	public void newGame() {
		model.generateRandomPattern();
		model.resetGuessedPattern();
		this.loop();
	}
	
	public void loop() {
		Scanner in = new Scanner(System.in);
		
		in.close();
	}
	
	public boolean isPlaying() {
		return false;
	}
	
}
