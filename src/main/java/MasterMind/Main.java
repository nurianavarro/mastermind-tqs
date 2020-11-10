package MasterMind;

public class Main {
	
	public static void main(String[] args) {
		//The length of the generated combination
		int LENGTH = 4;
		//Number of attempts to guess the combination
		int turns = 10;
		
		View view = new View(LENGTH, turns);
		Model model = new Model(LENGTH, turns);
		Controller controller = new Controller(view, model);
		controller.newGame();
		
	}
}
