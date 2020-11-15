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
	public void testInitializeLists() {
		Model m = new Model(LENGTH,turn);
		m.initializeLists();
		//SIMPLE LOOP TESTING
		
		//Case avoid loop
		int n = 0;
		m = new Model(LENGTH,n);
		m.initializeLists();
		assertEquals(m.getGuessedPatterns()[0], null);
		assertEquals(m.getHitsPattern()[0], null);
		
		//Case one iteration
		n = 1;
		m = new Model(LENGTH,n);
		m.initializeLists();
		for (int i = 0; i<n; i++) {
			assertTrue(m.getGuessedPatterns()[i].isEmpty());
			assertTrue(m.getHitsPattern()[i].isEmpty());
		}
		
		//Case two iterations
		n = 2;
		m = new Model(LENGTH,n);
		m.initializeLists();
		for (int i = 0; i<n; i++) {
			assertTrue(m.getGuessedPatterns()[i].isEmpty());
			assertTrue(m.getHitsPattern()[i].isEmpty());
		}
		
		//Case m iterations where m<n
		n = 10;
		m = new Model(LENGTH,n);
		m.initializeLists();
		for (int i = 0; i<(n-3); i++) {
			assertTrue(m.getGuessedPatterns()[i].isEmpty());
			assertTrue(m.getHitsPattern()[i].isEmpty());
		}
		
		//Case (n-1)
		//Same parameters as the last case, but n-1
		for (int i = 0; i<(n-1); i++) {
			assertTrue(m.getGuessedPatterns()[i].isEmpty());
			assertTrue(m.getHitsPattern()[i].isEmpty());
		}
	}
	
	@Test
	public void testBuildGuessedPattern() {
		MockModel mock = new MockModel(LENGTH,turn);
		mock.buildGuessedPattern(0);
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
		
		//DECISION COVERAGE
		
		//Test where hasWon is true
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
		assertTrue(m.hasWon());
		
		//Test where hasWon is false
		Model m2 = new Model(LENGTH,turn);
		m2.setRandomPattern(randomPattern);
		ArrayList<Integer> guessedPattern2 = new ArrayList<Integer>();
		guessedPattern2.add(2);
		guessedPattern2.add(1);
		guessedPattern2.add(4);
		guessedPattern2.add(3);
		m2.setGuessedPattern(guessedPattern2);
		m2.checkResult();
		assertFalse(m2.hasWon());
		
	}
	
	@Test
	public void testGenerateRandomPattern() {
		Model m = new Model(LENGTH,turn);
		m.generateRandomPattern();
		//Test if size of array is equal to LENGTH
		assertEquals(m.getRandomPattern().size(), m.getLENGTH());
		//Test if there is repeated numbers
		Set<Integer> set = new HashSet<Integer>(m.getRandomPattern());
		assertFalse(set.size() < m.getRandomPattern().size());
		//Test if there is all numbers are between 1 and 9
		for(int i=0; i<m.getRandomPattern().size(); i++) {
			assertFalse(m.getRandomPattern().get(i) < 1 && m.getRandomPattern().get(i) > 9);
		}
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
		
		//Test case when any number is in the combination
		Model m3 = new Model(LENGTH,turn);
		m3.setRandomPattern(randomPattern);
		ArrayList<Integer> guessedPattern3 = new ArrayList<Integer>();
		ArrayList<String> hitsPattern3 = new ArrayList<String>();
		guessedPattern3.add(5);
		guessedPattern3.add(6);
		guessedPattern3.add(7);
		guessedPattern3.add(8);
		hitsPattern3.add("X");
		hitsPattern3.add("X");
		hitsPattern3.add("X");
		hitsPattern3.add("X");
		m3.setGuessedPattern(guessedPattern3);
		m3.checkResult();
		assertEquals(m3.getCountW(),0);
		assertEquals(m3.getCountB(),0);
		assertEquals(m3.getHitsPattern()[0], hitsPattern3);
		
		//We have to make sure that the turn has been decremented
		assertEquals(m.getTurn(), (turn-1));
		assertEquals(m2.getTurn(), (turn-1));
		//GuessedPattern needs to be empty for the next iteration
		assertTrue(m.getGuessedPattern().isEmpty());
		assertTrue(m2.getGuessedPattern().isEmpty());
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
		MockModel mock = new MockModel(LENGTH,turn);
		mock.updateTurn();
		//Test if turn decrements
		Model m = new Model(LENGTH,turn);
		m.updateTurn();
		assertEquals(m.getTurn(),(turn-1));
	}
}
