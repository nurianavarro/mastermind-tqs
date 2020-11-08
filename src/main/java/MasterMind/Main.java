package MasterMind;

public class Main {
	int LENGTH = 4;
	int turns = 10;
	View view = new View(LENGTH, turns);
	Model model = new Model(LENGTH);
	Controller controller = new Controller(view, model);
}
