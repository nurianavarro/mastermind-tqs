package MasterMind;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
		MockModel m = new MockModel(4);
		m.generateRandomPattern();
		assertEquals(m.getIndices().size(), m.getLENGTH());

	}
}
