package MasterMind;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ModelTest {
	
	int LENGTH = 4;
	int turn = 10;

	@Test
	public void testConstructor() {
		Model m = new Model(LENGTH,turn);
		assertEquals(m.getCountB(), 0);
		assertEquals(m.getCountW(), 0);
		assertEquals(m.getTurn(), turn);
		assertEquals(m.getInitialTurns(), turn);
		//The guessedPattern should be empty
		assertTrue(m.getGuessedPattern().isEmpty());
		//It has to create a random pattern, so it should not be empty
		assertFalse(m.getRandomPattern().isEmpty());
	}
	
	@Test
	public void testBuildGuessedPattern() {
		Model m = new Model(LENGTH,turn);
		ArrayList<Integer> guessedPattern2 = new ArrayList<Integer>();
		ArrayList<Integer>[] guessedPatterns = new ArrayList[1];
		guessedPatterns[0] = new ArrayList<Integer>();
		guessedPattern2.add(1);
		guessedPattern2.add(2);
		guessedPattern2.add(3);
		guessedPattern2.add(4);
		guessedPatterns[0].add(1);
		guessedPatterns[0].add(2);
		guessedPatterns[0].add(3);
		guessedPatterns[0].add(4);
		m.buildGuessedPattern(1);
		m.buildGuessedPattern(2);
		m.buildGuessedPattern(3);
		m.buildGuessedPattern(4);
		assertEquals(m.getGuessedPattern(),guessedPattern2);
		assertEquals(m.getGuessedPatterns()[0], guessedPatterns[0]);
		//Every time we are building the pattern, the hits have
		//to be reseted
		assertEquals(m.getCountW(),0);
		assertEquals(m.getCountB(),0);
	}
	
	@Test
	public void testIsFilled() {
		//Mock
		MockModel mock = new MockModel(LENGTH,turn);
		assertFalse(mock.isFilled());
		//Test with shorter pattern
		Model m = new Model(LENGTH,turn);
		m.generateRandomPattern();
		ArrayList<Integer> guessedPattern = new ArrayList<Integer>();
		guessedPattern.add(1);
		guessedPattern.add(2);
		guessedPattern.add(3);
		m.setGuessedPattern(guessedPattern);
		//It should be false because the length is 3
		assertFalse(m.isFilled());
		
		//Test with the right length
		Model m2 = new Model(LENGTH,turn);
		m2.generateRandomPattern();
		ArrayList<Integer> guessedPattern2 = new ArrayList<Integer>();
		guessedPattern2.add(1);
		guessedPattern2.add(2);
		guessedPattern2.add(3);
		guessedPattern2.add(4);
		m2.setGuessedPattern(guessedPattern2);
		//It should be true because the length is 4
		assertTrue(m2.isFilled());
		
		//Test with larger pattern
		Model m3 = new Model(LENGTH,turn);
		m3.generateRandomPattern();
		ArrayList<Integer> guessedPattern3 = new ArrayList<Integer>();
		guessedPattern.add(1);
		guessedPattern.add(2);
		guessedPattern.add(3);
		guessedPattern.add(4);
		guessedPattern.add(5);
		m3.setGuessedPattern(guessedPattern3);
		//It should be false because the length is 5
		assertFalse(m3.isFilled());
		
	}
	@Test
	public void testHasWon() {
		//Mock
		MockModel mock = new MockModel(LENGTH,turn);
		assertFalse(mock.hasWon());
		Model m = new Model(LENGTH,turn);
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
		assertEquals(result,m.hasWon());
		
		//Test if is in different position
		Model m2 = new Model(LENGTH,turn);
		m2.setRandomPattern(randomPattern);
		ArrayList<Integer> guessedPattern2 = new ArrayList<Integer>();
		guessedPattern2.add(2);
		guessedPattern2.add(1);
		guessedPattern2.add(4);
		guessedPattern2.add(3);
		m2.setGuessedPattern(guessedPattern2);
		m2.checkResult();
		boolean result2 = true;
		if(m2.getCountW() != m2.getLENGTH()) {
			result2 = false;
		}
		assertEquals(result2,m2.hasWon());
		//ADD DELETIONS LATER
	}
	
	@Test
	public void testGenerateRandomPattern() {
		Model m = new Model(LENGTH,turn);
		m.generateRandomPattern();
		//Test if size of array is equal to LENGTH
		assertEquals(m.getRandomPattern().size(), m.getLENGTH());
		//Test if there is repeated numbers
		boolean repeatedNumbers = false;
		Set<Integer> set = new HashSet<Integer>(m.getRandomPattern());
		if(set.size() < m.getRandomPattern().size()) {
			repeatedNumbers = true;
		}	
		assertFalse(repeatedNumbers);
		//Test if there is all numbers are between 0 and 9
		boolean wrongNumber = false;
		for(int i=0; i<m.getRandomPattern().size(); i++) {
			if (m.getRandomPattern().get(i) < 0 && m.getRandomPattern().get(i) > 9) {
				wrongNumber = true;
			}
		}
		assertFalse(wrongNumber);
	}
	
	@Test
	public void testCheckResult() {
		Model m = new Model(LENGTH,turn);
		ArrayList<Integer> randomPattern = new ArrayList<Integer>();
		randomPattern.add(1);
		randomPattern.add(2);
		randomPattern.add(3);
		randomPattern.add(4);
		m.setRandomPattern(randomPattern);
		ArrayList<Integer> guessedPattern = new ArrayList<Integer>();
		ArrayList<String> hitsPattern = new ArrayList<String>();
		guessedPattern.add(1);
		guessedPattern.add(2);
		guessedPattern.add(3);
		guessedPattern.add(4);
		hitsPattern.add("W");
		hitsPattern.add("W");
		hitsPattern.add("W");
		hitsPattern.add("W");
		m.setGuessedPattern(guessedPattern);
		m.checkResult();
		//Test if it is the same result
		assertEquals(m.getCountW(),4);
		assertEquals(m.getCountB(),0);
		assertEquals(m.getHitsPattern()[0], hitsPattern);
		
		//Test if is in different position
		Model m2 = new Model(LENGTH,turn);
		m2.setRandomPattern(randomPattern);
		ArrayList<Integer> guessedPattern2 = new ArrayList<Integer>();
		ArrayList<String> hitsPattern2 = new ArrayList<String>();
		guessedPattern2.add(2);
		guessedPattern2.add(1);
		guessedPattern2.add(4);
		guessedPattern2.add(3);
		hitsPattern2.add("B");
		hitsPattern2.add("B");
		hitsPattern2.add("B");
		hitsPattern2.add("B");
		m2.setGuessedPattern(guessedPattern2);
		m2.checkResult();
		assertEquals(m2.getCountW(),0);
		assertEquals(m2.getCountB(),4);
		assertEquals(m2.getHitsPattern()[0], hitsPattern2);
		
		//We have to make sure that the turn has been decremented
		assertEquals(m.getTurn(), (turn-1));
		//GuessedPattern needs to be empty for the next iteration
		assertTrue(m.getGuessedPattern().isEmpty());
	}
	
	@Test
	public void testResetGuessedPattern() {
		MockModel m = new MockModel(LENGTH,turn);
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
		m.resetGuessedPattern();
		//Test if countWhite is 0
		assertEquals(m.getCountW(),0);
		//Test if countBlack is 0
		assertEquals(m.getCountB(),0);
		//Test if guessedPattern is empty
		assertTrue(m.getGuessedPattern().isEmpty());
		//Test if guessedPattern is empty
		assertTrue(m.getRandomPattern().isEmpty());
		
		//Test if turn has the default value
	}
	
	@Test
	public void testUpdateTurn() {
		//Test if turn decrements
		Model m = new Model(LENGTH,turn);
		m.updateTurn();
		assertEquals(m.getTurn(),(turn-1));
	}
}
