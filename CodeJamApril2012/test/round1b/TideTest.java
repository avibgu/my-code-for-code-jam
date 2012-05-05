package round1b;

import static org.junit.Assert.*;

import org.junit.Test;

public class TideTest {

	@Test
	public void test() {

		int H = 100;
		int N = 3;
		int M = 3;

		int[][] ceil = new int[][] { { 500, 100, 500 }, { 100, 100, 500 },
				{ 500, 500, 500 } };
		int[][] floor = new int[][] { { 10, 10, 10 }, { 10, 10, 10 },
				{ 10, 10, 10 } };

		assertEquals(18.0, Tide.calc(H, N, M, ceil, floor), 0.00001);
	}

}
