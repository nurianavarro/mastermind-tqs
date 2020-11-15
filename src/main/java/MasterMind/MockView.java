package MasterMind;

public class MockView extends View {

	public MockView(int length) {
		super(length);
		// TODO Auto-generated constructor stub
	}

	public void displayWrongNumber() {
		System.out.println("");
		System.out.println("Error: Only allowed numbers from 1 to 9");
		System.out.println("The combination must have " + LENGTH + " numbers");
	}
	
	public void displayError() {
		System.out.println("");
		System.out.println("Error: wrong command");
	}
}
