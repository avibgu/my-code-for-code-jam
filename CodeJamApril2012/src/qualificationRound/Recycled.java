package qualificationRound;

import java.util.HashMap;
import java.util.Map;

public class Recycled {

	public static final Map<Double, String> map = new HashMap<Double, String>();

	public static double howMany2(double A, double B) {

		double count = 0;

		for (double i = A; i < B; i++) {

			String I = get(i);
			String II = I + I;

			for (double j = i + 1; j <= B; j++) {

				String J = get(j);

				if (II.contains(J))
					count++;
			}
		}

		return count;
	}

	private static String get(double key) {

		String value = map.get(key);

		if (null == value) {

			value = String.valueOf(key);
			map.put(key, value);
		}

		return value;
	}


	public static int howMany(int A, int B) {

		int tmp = A;
		int digits = 0;
		int count = 0;
		
		while (tmp >= 1){
			digits++;
			tmp /= 10;
		}
		
		int mul = (int)Math.pow(10, digits-1);
		
		for (int a = A; a < B; a++) {

			tmp = a;
			
			for (int i = 1; i < digits; i++){
				
				tmp = (tmp / 10) + ((tmp % 10) * mul);
				
				if (tmp > a && tmp <= B)
					count++;
			}
		}

		return count;
	}
}
