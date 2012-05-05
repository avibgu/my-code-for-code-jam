package qualificationRound;

import static org.junit.Assert.*;

import org.junit.Test;

import qualificationRound.Dancing;

public class DancingTest {

	@Test
	public void test1() {

		int result = Dancing.howMany(3, 1, 5, new int[]{15,13,11});
		assertEquals(3, result);
	}
	
	@Test
	public void test2() {

		int result = Dancing.howMany(3, 0, 8, new int[]{23,22,21});
		assertEquals(2, result);
	}
	
	@Test
	public void test3() {

		int result = Dancing.howMany(2, 1, 1, new int[]{8,0});
		assertEquals(1, result);
	}
	
	@Test
	public void test4() {
		
		int result = Dancing.howMany(6, 2, 8, new int[]{29,20,8,18,18,21});
		assertEquals(3, result);
	}

}
