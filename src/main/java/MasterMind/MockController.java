package MasterMind;

public class MockController extends Controller{
	View view;
	Model model;
	
	
	public MockController(View v, Model m){
		super(v,m);
		model = m;
		view = v;
	}
	
	public void newGame() {
		view.startNewGame();
		model.generateRandomPattern();
		model.resetGuessedPattern();
		this.loop();
	}
	
	public void loop() {
		while(true) {
			
		}
	}
	
	
}
