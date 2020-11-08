package MasterMind;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControllerTest {

	@Test
	public void testTurn() {
		View view = new View(4,9);
		Model model = new Model(4);
		Controller controller = new Controller(view, model);
		assertEquals(view.turn, 9);
	}

}
