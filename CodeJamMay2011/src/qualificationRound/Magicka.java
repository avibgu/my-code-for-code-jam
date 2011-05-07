package qualificationRound;

import java.util.HashMap;
import java.util.HashSet;

public class Magicka {

	public static String[] calc(String[] cs,
			String[] ds, int n, String series){
		
		HashMap<String, String> cMap =
			new HashMap<String, String>();
		
		HashMap<String, String> dMap =
			new HashMap<String, String>();
		
		for (String c: cs){
			
			if (c.length() < 2) continue;
			
			String p1 = String.valueOf(c.charAt(0));
			String p2 = String.valueOf(c.charAt(1));
			
			cMap.put(p1, p2);
			cMap.put(p2, p1);
		}
		
		for (String d: ds){
			
			if (d.length() < 2) continue;
			
			String p1 = String.valueOf(d.charAt(0));
			String p2 = String.valueOf(d.charAt(1));
			
			dMap.put(p1, p2);
			dMap.put(p2, p1);
		}
		
		int idx = -1;
		
		char[] chars = series.toCharArray();
		
		HashSet<String> set = new HashSet<String>();
		
		for (int i=0; i < chars.length; i++) {
			
			String c = String.valueOf(chars[i]);
			
			if (set.contains(c) &&
					!String.valueOf(chars[i-1]).equals(
							cMap.get(c)) ){
				
				idx = i+1;
				set.clear();
			}
			else if (dMap.containsKey(c)){
				set.add(dMap.get(c));
			}
		}
		
		if (idx >= series.length())
			series = "";
		else if (idx != -1)
			series = series.substring(idx);
		
		for (String c: cs){

			if (c.length() < 2) continue;
			
			String p1 = String.valueOf(c.charAt(0)) + String.valueOf(c.charAt(1));
			String p2 = String.valueOf(c.charAt(1)) + String.valueOf(c.charAt(0));
			String np = c.substring(2);
			
			int idx1 = -1;
			int idx2 = -1;
			
			while(	((idx1 = series.indexOf(p1)) >= 0) |
					((idx2 = series.indexOf(p2)) >= 0)	){
				
				if (idx1 < 0) idx = idx2;
				else if (idx2 < 0) idx = idx1;
				else idx = (idx1 < idx2) ? idx1 : idx2;
			
				String before = (idx == 0) ? "" : series.substring(0, idx);
				String after = (idx == series.length()-2) ?  "" : series.substring(idx+2);

				series = before + np + after;
			}
		}
		
		chars = series.toCharArray();
		
		String[] ans = new String[chars.length];
		
		for (int i=0; i < chars.length; i++) {
			ans[i] = String.valueOf(chars[i]);
		}
		
		System.out.println(series);
		
		return ans;
	}
}
