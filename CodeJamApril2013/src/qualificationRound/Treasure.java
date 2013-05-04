package qualificationRound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Treasure {

	public static Map<Integer, Integer> keysThatIHave = new HashMap<Integer, Integer>();
	public static Map<Integer, List<Chest>> keyChestMap = new HashMap<Integer, List<Chest>>();

	public static String doSomething(int numOfkeys, int[] keys,
			int numOfChests, Chest[] chests) {

		initKeysThatIHave(keys);
		initKeyChestMap(chests);

		while(!keysThatIHave.isEmpty()){
			
			int key = keysThatIHave.keySet().iterator().next();

			System.out.println(key + "bla bla dynamic programing..");
		}
		
		return null;
	}

	private static void initKeysThatIHave(int[] pKeys) {

		keysThatIHave.clear();

		for (int key : pKeys) {

			Integer value = keysThatIHave.get(key);

			if (null == value)
				value = 0;

			keysThatIHave.put(key, 1 + value);
		}
	}

	private static void initKeyChestMap(Chest[] pChests) {

		keyChestMap.clear();

		for (Chest chest : pChests) {

			if (!keyChestMap.containsKey(chest.mKeyType))
				keyChestMap.put(chest.mKeyType, new ArrayList<Chest>());

			keyChestMap.get(chest.mKeyType).add(chest);
		}
	}
}
