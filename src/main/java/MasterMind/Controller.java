package MasterMind;

public class Controller {
	View view;
	Model model;
	
	Controller(View v, Model m){
		view = v;
		model = m;
		view.turn = 9;
	}

}
