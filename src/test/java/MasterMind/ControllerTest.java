package MasterMind;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControllerTest {

	@Test
	public void testTurn() {
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller(view, model);
		assertEquals(view.turn, 9);
	}

}
