package round1b;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Osmos {

	private int A;
	private int N;
	private int[] V;

	private Map<String, Integer> cache = null;

	public Osmos(int pA, int pN, int[] pV) {

		A = pA;
		N = pN;
		V = pV;

		cache = new HashMap<String, Integer>();
	}

	public int calc() {

		Arrays.sort(V);

		return calc(0, A, 0);
	}

	private int calc(int i, int a, int sum) {

		Integer result = 0;

		if (i == N || sum == N)
			return sum;

		else if (null != (result = cache.get(i + "-" + a)))
			return result;

		else if (V[i] < a)
			result = calc(i + 1, a + V[i], sum);

		else
			result = Math.min(calc(i, a + a - 1, sum + 1),
					calc(i + 1, a, sum + 1));

		cache.put(i + "-" + a, result);

		return result;
	}

}
