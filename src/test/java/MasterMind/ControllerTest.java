package MasterMind;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class ControllerTest {
	int LENGTH = 4;
	int turn = 9;
	
	@Test
	public void testNewGame() {
		View view = new View(LENGTH);
		MockModel model = new MockModel(LENGTH, turn);
		Controller controller = new Controller(view, model);
		//Create a game to initialize variables
		model.generateRandomPattern();
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
	}
	@Test
	public void testLoop() {
		View view = new View(LENGTH);
		Model model = new Model(LENGTH, turn);
		MockController controller = new MockController(view, model);
		//FALSE = finish execution
		//TRUE = continue
		
		//With option 'quit' it should return false
		Scanner input = new Scanner("quit");
		assertFalse(controller.loop(input));
		
		//With option 'instructions' it should return true
		input = new Scanner("instructions");
		assertTrue(controller.loop(input));
		
		//With wrong option it should continue execution
		input = new Scanner("sfgf");
		assertTrue(controller.loop(input));
		
		input.close();

	}
	
	@Test
	public void testIsPlaying() {
		// If the user has won
		View view = new View(LENGTH);
		Model model = new Model(LENGTH, turn);
		Controller controller = new Controller(view, model);
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
		assertFalse(controller.isPlaying());
		
		//Test if there is 0 turns
		View view2 = new View(LENGTH);
		Model model2 = new Model(LENGTH,0);
		Controller controller2 = new Controller(view2, model2);
		assertFalse(controller2.isPlaying());
		
		//Test if still playing
		View view3 = new View(LENGTH);
		Model model3 = new Model(LENGTH, 4);
		Controller controller3 = new Controller(view3, model3);
		assertTrue(controller3.isPlaying());
	}

}
