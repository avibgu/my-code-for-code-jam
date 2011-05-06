package practice;

public class Rotate {

	/**
	 * 
	 * @param board '.'-empty, 'R'-Red, 'B'-Blue
	 * @param n board dimensions
	 * @param k how many in row to win
	 * 
	 * @return 0-none, 1-red, 2-blue, 3-both
	 */
	public static int whoWins(String[][] board, int n, int k){

		for (String[] row : board) {
	
			for (String col : row) {
				
				if (col.compareTo("R") == 0)
					return 1;
				
				if (col.compareTo("B") == 0)
					return 2;
			}
		}
		
		return 0;
	}
}
