package MasterMind;

public class Main {
	View view = new View();
	Model model = new Model(4);
	Controller controller = new Controller(view, model);
}
