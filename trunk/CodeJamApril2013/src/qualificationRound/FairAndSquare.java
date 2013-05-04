package qualificationRound;

import java.util.HashSet;
import java.util.Set;

public class FairAndSquare {

	public static Set<Long> palindrome = new HashSet<Long>();
	public static Set<Long> fairAndSquare = new HashSet<Long>();

	static {

		long max = (long) Math.pow(10, 7);

		for (long i = 0; i <= max; i++) {

			long square = i * i;

			boolean iPal = false;

			if (!palindrome.contains(i)) {

				iPal = isPalindrome(i);

				if (iPal)
					palindrome.add(i);
			}

			if (iPal) {

				boolean sqPal = false;

				if (!palindrome.contains(square)) {

					sqPal = isPalindrome(square);

					if (sqPal)
						palindrome.add(square);
				}

				if (sqPal)
					fairAndSquare.add(square);
			}
		}
	}

	public static long count(long a, long b) {

		long sum = 0;

		for (long i = a; i <= b; i++)
			if (fairAndSquare.contains(i))
				sum++;

		return sum;
	}

	private static boolean isPalindrome(long num) {

		boolean answer = true;

		String strNum = String.valueOf(num);

		int length = strNum.length();

		for (int i = 0; i < (length / 2) + 1; ++i) {

			if (strNum.charAt(i) != strNum.charAt(length - i - 1)) {

				answer = false;
				break;
			}
		}

		return answer;
	}
}
