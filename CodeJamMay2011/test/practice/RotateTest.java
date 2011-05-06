package practice;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RotateTest {

	private String[][] _board;
	private int _n;
	private int _k;
	
	@Before
	public void setUp() throws Exception {
		
		_n = 7;
		_k = 4;
		_board = new String[_n][_n];
		
		for (int i = 0; i < _board.length; i++)
			for (int j = 0; j < _board[i].length; j++)
				_board[i][j] = ".";
	}

	@Test
	public void testEmptyBoard() {
		assertEquals(0, Rotate.whoWins(_board, _n, _k));
	}
	
	@Test
	public void testRedRowWins() {
		
		_board[0][0] = "R";
		_board[0][1] = "R";
		_board[0][2] = "R";
		_board[0][3] = "R";
		
		assertEquals(1, Rotate.whoWins(_board, _n, _k));
	}
	
	@Test
	public void testRedColWins() {
		
		_board[0][0] = "R";
		_board[1][0] = "R";
		_board[2][0] = "R";
		_board[3][0] = "R";
		
		assertEquals(1, Rotate.whoWins(_board, _n, _k));
	}
	
	@Test
	public void testRedDiagWins() {
		
		_board[0][0] = "R";
		_board[1][1] = "R";
		_board[2][2] = "R";
		_board[3][3] = "R";
		
		assertEquals(1, Rotate.whoWins(_board, _n, _k));
	}
	
	@Test
	public void testRedBlueWins() {
		
		_board[0] = new String[]{"B","B","B","B",".",".","."};
		
		assertEquals(2, Rotate.whoWins(_board, _n, _k));
	}
	
	@Test
	public void testBlueColWins() {
		
		_board[0][0] = "B";
		_board[1][0] = "B";
		_board[2][0] = "B";
		_board[3][0] = "B";
		
		assertEquals(2, Rotate.whoWins(_board, _n, _k));
	}
	
	@Test
	public void testBlueDiagWins() {
		
		_board[0][0] = "B";
		_board[1][1] = "B";
		_board[2][2] = "B";
		_board[3][3] = "B";
		
		assertEquals(2, Rotate.whoWins(_board, _n, _k));
	}
	
	@Test
	public void testRedWins() {
		
		_board = new String[][] 
		        {	{".",".",".",".",".",".","."},
					{".",".",".",".",".",".","."},
		        	{"B",".",".",".",".",".","."},
		        	{"R","R",".",".",".",".","."},
		        	{"B","R","B",".",".",".","."},
		        	{"R","R","B","R",".",".","."},
		        	{"B","R","B","R","B",".","."}	};
		
		assertEquals(1, Rotate.whoWins(_board, _n, _k));
	}
	
	@Test
	public void testBlueWins() {
		
		_board = new String[][] 
		        {	{".",".",".",".",".",".","."},
					{".",".",".",".",".",".","."},
		        	{".",".",".",".",".",".","."},
		        	{".",".",".",".","R","B","."},
		        	{".",".",".",".","R","B","."},
		        	{".",".",".","B","B","B","."},
		        	{".","B","R","B","R","B","."}	};
		
		assertEquals(2, Rotate.whoWins(_board, _n, _k));
	}
}
