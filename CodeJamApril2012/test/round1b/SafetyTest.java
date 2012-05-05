package round1b;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SafetyTest {

	@Test
	public void test() {

		double[] result = Safety.calc(new int[]{20, 10});
		
		assertEquals(1/3, result[0], 0.1);
		assertEquals(2/3, result[0], 0.1);
	}

}
