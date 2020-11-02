package MasterMind;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModelTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	@Test
	public void testIsFilled() {
		MockModel m = new MockModel();
		boolean result;
		result = m.isFilled();
		assertEquals(result, false);
		
	}
	
	public void testHasWon() {
		MockModel m = new MockModel();
		boolean result;
		result = m.hasWon();
		assertEquals(result, false);
		
	}
}
