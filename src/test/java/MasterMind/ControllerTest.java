package MasterMind;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ControllerTest {
	int LENGTH = 4;
	int turn = 9;
	
	@Test
	public void testNewGame() {
		View view = new View(LENGTH, turn);
		MockModel model = new MockModel(LENGTH);
		MockController controller = new MockController(view, model, turn);
		//Create a game to initialize variables
		model.generateRandomPattern();
		ArrayList<Integer> randomPattern = new ArrayList<Integer>();
		randomPattern.add(1);
		randomPattern.add(2);
		randomPattern.add(3);
		randomPattern.add(4);
		model.setRandomPattern(randomPattern);
		ArrayList<Integer> guessedPattern = new ArrayList<Integer>();
		guessedPattern.add(1);
		guessedPattern.add(2);
		guessedPattern.add(3);
		guessedPattern.add(4);
		model.setGuessedPattern(guessedPattern);
		model.checkResult();
		//Call the function we are testing
		controller.newGame();
		assertEquals(model.getCountW(), 0);
		assertEquals(model.getCountB(), 0);
		assertEquals(view.getTurn(), turn);
	}

}
