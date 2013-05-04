package qualificationRound;

public class Lawnmower {

	public static String isLegalPattern(int n, int m, int[][] lawn) {

		int[] rowsSums = new int[n];
		int[] colsSums = new int[m];

		for (int i = 0; i < lawn.length; i++) {

			for (int j = 0; j < lawn[i].length; j++) {

				rowsSums[i] += lawn[i][j];
				colsSums[j] += lawn[i][j];
			}
		}

		for (int i = 0; i < lawn.length; i++) {

			for (int j = 0; j < lawn[i].length; j++) {

				int h = lawn[i][j];

				int x = h * m;
				int y = h * n;

				if (rowsSums[i] > x && colsSums[j] > y)
					return "NO";
			}
		}

		return "YES";
	}
}
