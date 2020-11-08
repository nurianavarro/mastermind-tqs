package MasterMind;

public class MockController extends Controller{
	View view;
	Model model;
	int turn;
	int initialTurns;
	
	public MockController(View v, Model m, int initialTurns){
		super(v,m);
		model = m;
		view = v;
		this.turn = initialTurns;
		this.initialTurns = initialTurns;
	}
	
	public void newGame() {
		view.startNewGame();
		turn = initialTurns;
		model.generateRandomPattern();
		model.resetGuessedPattern();
	}
	
	
}
