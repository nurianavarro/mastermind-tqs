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
		System.out.println(m.getIndices());
		assertEquals(m.getIndices().size(), m.getLENGTH());
		//Test if there is repeated numbers
		boolean repeatedNumbers = false;
		Set<Integer> set = new HashSet<Integer>(m.getIndices());
		if(set.size() < m.getIndices().size()) {
			repeatedNumbers = true;
		}	
		assertEquals(repeatedNumbers, false);

	}
}
