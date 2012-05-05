package round1b;

public class Tide {

	public static int n = 0;
	public static int m = 0;

	public static int[][] ceil = null;
	public static int[][] floor = null;

	public static double[][] answer = null;

	public static double calc(int pHeightOfWaterLevel, int pN, int pM,
			int[][] pCeil, int[][] pFloor) {

		n = pN;
		m = pM;

		ceil = pCeil;
		floor = pFloor;

		answer = new double[n][m];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				answer[i][j] = -1.0;

		return recursion(0, 0, 0.0, pHeightOfWaterLevel, true);
	}

	public static double recursion(int i, int j, double time, double water,
			boolean bool) {

		if (i == n - 1 && j == m - 1)
			return time;

		else if (i == n || j == m)
			return Double.MAX_VALUE;

		if (-1.0 != answer[i][j])
			return answer[i][j];

		double right = Double.MAX_VALUE;
		double down = Double.MAX_VALUE;

		boolean tBool = bool;
		double timeToLeave = 0.0;

		if (i != n - 1) {

			if (ceil[i + 1][j] - floor[i + 1][j] >= 50) {

				double ceilWaterDiff = ceil[i + 1][j] - water;

				if (ceilWaterDiff < 50) {
					timeToLeave = (50 - ceilWaterDiff) / 10;
					tBool = false;
				}

				if (water - floor[i][j] - timeToLeave * 10 < 20)
					timeToLeave += 10;

				else
					timeToLeave += 1;

				if (ceilWaterDiff >= 50
						&& (water - floor[i][j] - timeToLeave * 10 < 20)
						&& tBool)
					timeToLeave = 0;

				right = recursion(i + 1, j, time + timeToLeave, water - 10
						* timeToLeave, tBool);
			}
		}

		tBool = bool;
		timeToLeave = 0.0;

		if (j != m - 1) {

			if (ceil[i][j + 1] - floor[i][j + 1] >= 50) {

				double ceilWaterDiff = ceil[i][j + 1] - water;

				if (ceilWaterDiff < 50) {
					timeToLeave = (50 - ceilWaterDiff) / 10;
					tBool = false;
				}

				if (water - floor[i][j] - timeToLeave * 10 < 20)
					timeToLeave += 10;

				else
					timeToLeave += 1;

				if (ceilWaterDiff >= 50
						&& (water - floor[i][j] - timeToLeave * 10 < 20)
						&& tBool)
					timeToLeave = 0;

				down = recursion(i, j + 1, time + timeToLeave, water - 10
						* timeToLeave, tBool);
			}
		}

		answer[i][j] = Math.min(right, down);

		return answer[i][j];
	}
}
