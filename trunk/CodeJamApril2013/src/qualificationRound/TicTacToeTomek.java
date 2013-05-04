package qualificationRound;

public class TicTacToeTomek {

	public static final int X = 2;
	public static final int O = 3;
	public static final int T = 5;
	public static final int EMPTY = 0;

	private static final int X_WINS_1 = (int) Math.pow(X, 4);
	private static final int X_WINS_2 = (int) Math.pow(X, 3) * T;

	private static final int O_WINS_1 = (int) Math.pow(O, 4);
	private static final int O_WINS_2 = (int) Math.pow(O, 3) * T;

	// "X won" (the game is over, and X won)
	// "O won" (the game is over, and O won)
	// "Draw" (the game is over, and it ended in a draw)
	// "Game has not completed" (the game is not over yet)
	// If there are empty cells, and the game is not over, you should output
	// "Game has not completed", even if the outcome of the game is
	// inevitable.
	public static String findWinner(int[][] board) {

		boolean someZero = false;

		int[] results = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {

				results[i] *= board[i][j];
				results[i + 4] *= board[j][i];
			}
		}

		results[8] = board[0][0] * board[1][1] * board[2][2] * board[3][3];
		results[9] = board[0][3] * board[1][2] * board[2][1] * board[3][0];

		for (int i = 0; i < results.length; i++) {

			if (X_WINS_1 == results[i] || X_WINS_2 == results[i])
				return "X won";

			else if (O_WINS_1 == results[i] || O_WINS_2 == results[i])
				return "O won";

			if (0 == results[i])
				someZero = true;
		}

		return someZero ? "Game has not completed" : "Draw";
	}
}
