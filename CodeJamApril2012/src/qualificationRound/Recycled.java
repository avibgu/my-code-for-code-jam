package qualificationRound;

import java.util.HashMap;
import java.util.Map;

public class Recycled {

	public static final Map<Double, String> map = new HashMap<Double, String>();
	
	public static double howMany(double A, double B){
		
		double count = 0;
		
		for (double i = A; i < B; i++){
			
			String I = get(i);
			String II = I + I;
			
			for (double j = i + 1; j <= B; j++){
				
				String J = get(j);

				if (II.contains(J))
					count++;
			}
		}
		
		return count;
	}

	private static String get(double key) {

		String value = map.get(key);
		
		if (null == value){
			
			value = String.valueOf(key);
			map.put(key, value);
		}
		
		return value;
	}
}
