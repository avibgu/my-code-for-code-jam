package qualificationRound;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BotTrustTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCalcSeconds1() {
		String[] input = "4 O 2 B 1 B 2 O 4".split(" ");
		assertEquals(6, BotTrust.calcSeconds(4, input));
	}
	
	@Test
	public void testCalcSeconds2() {
		String[] input = "3 O 5 O 8 B 100".split(" ");
		assertEquals(100, BotTrust.calcSeconds(3, input));
	}
	
	@Test
	public void testCalcSeconds3() {
		String[] input = "2 B 2 B 1".split(" ");
		assertEquals(4, BotTrust.calcSeconds(2, input));
	}
}
