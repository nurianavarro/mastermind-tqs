package MasterMind;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ModelTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	@Test
	public void testIsFilled() {
		MockModel m = new MockModel(4);
		boolean result;
		result = m.isFilled();
		assertEquals(result, false);
		
	}
	@Test
	public void testHasWon() {
		MockModel m = new MockModel(4);
		boolean result;
		result = m.hasWon();
		assertEquals(result, false);
		
	}
	@Test
	public void testCheckIfContains() {
		MockModel m = new MockModel(4);
		boolean result;
		result = m.checkIfContains();
		assertEquals(result, true);
		
	}
	@Test
	public void testGenerateRandomPattern() {
		Model m = new Model(4);
		m.generateRandomPattern();
		//Test if size of array is equal to LENGTH
		assertEquals(m.getRandomPattern().size(), m.getLENGTH());
		//Test if there is repeated numbers
		boolean repeatedNumbers = false;
		Set<Integer> set = new HashSet<Integer>(m.getRandomPattern());
		if(set.size() < m.getRandomPattern().size()) {
			repeatedNumbers = true;
		}	
		assertEquals(repeatedNumbers, false);
	}
	
	@Test
	public void testCheckResult() {
		MockModel m = new MockModel(4);
		ArrayList<Integer> randomPattern = new ArrayList<Integer>();
		randomPattern.add(1);
		randomPattern.add(2);
		randomPattern.add(3);
		randomPattern.add(4);
		m.setRandomPattern(randomPattern);
		ArrayList<Integer> guessedPattern = new ArrayList<Integer>();
		guessedPattern.add(1);
		guessedPattern.add(2);
		guessedPattern.add(3);
		guessedPattern.add(4);
		m.setGuessedPattern(guessedPattern);
		m.checkResult();
		boolean result = false;
		if(m.getCountW()==m.getLENGTH()) {
			result = true;
		}
		//Test if it is the same result
		assertEquals(result,true);
	}
}
