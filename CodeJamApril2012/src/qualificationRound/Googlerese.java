package qualificationRound;

public class Googlerese {

	public static String translate(String pInput) {

		StringBuilder sb = new StringBuilder(pInput.length());

		// a b c d e f g h i j k l m n o p q r s t u v w x y z
		// y h e s o c v x d u i g l b k r z t n w j p f m a q

		char[] table = new char[] { 'y', 'h', 'e', 's', 'o', 'c', 'v', 'x',
				'd', 'u', 'i', 'g', 'l', 'b', 'k', 'r', 'z', 't', 'n', 'w',
				'j', 'p', 'f', 'm', 'a', 'q' };

		for (char c : pInput.toCharArray()){
			
			if (' ' == c)
				sb.append(' ');
			else
				sb.append(table[c - 'a']);
		}
		
		return sb.toString();
	}
}
