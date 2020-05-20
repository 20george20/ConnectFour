
public class ConnectFour implements BoardGame {
	private int[][] board; // game board for playing ConnectFour
	private int currentPlayer; // stores the current player's turn
	private Position[] winningPositions; //stores row+col coordinates when someone wins
	private int winner; // stores which player wins (0 == draw)
	/**
	 * constructor for the class
	 */
	public ConnectFour()	{
		newGame();
	}
	
	/**
     * Prepares the board for a new game.
     */
	public void newGame() {
		board = new int[6][7];
		for(int r = 0; r < 6; r++) {
			for(int c = 0; c < 7; c++) {
				board[r][c] = 0;
			}
		}
		currentPlayer = 1;
		winningPositions = null;
	}
	/**
     * Is the game over?
     * @return true if the game is over, false otherwise
     */
	public boolean gameOver() {
		winner = getWinner();
		if(winner > 0)
			return true;
		else
			return false;
	}
	/**
     * Who is the winner?
     * @return 0 if there is no winner, 1 if the first player is a winner, 2 if the second player is a winner.
     */
	public int getWinner() {
		int [][] b = getBoard();
		//horizontal
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 4; c++) {
				if(b[r][c] == b[r][c+1] && b[r][c] == b[r][c+2] && b[r][c] == b[r][c+3] && b[r][c] != 0)
					return b[r][c];
			}
		}
		//vertical
		for (int c=0; c<7;c++) {
			for (int r = 5; r>=3; r--) {
				if(b[r][c] == b[r-1][c] && b[r][c] == b[r-2][c] && b[r][c] == b[r-3][c] && b[r][c] != 0)
					return b[r][c];
			}
		}
		//diagonal /
		for (int r=3; r<6; r++) {
			for (int c=0; c< 4; c++) {
				if(b[r][c] == b[r-1][c+1] && b[r][c] == b[r-2][c+2] && b[r][c] == b[r-3][c+3] && b[r][c] != 0)
					return b[r][c];
			}
		}
		//diagonal \
		for (int r=5; r>=3; r--) {
			for (int c=6; c>=3; c--) {
				if(b[r][c] == b[r-1][c-1] && b[r][c] == b[r-2][c-2] && b[r][c] == b[r-3][c-3] && b[r][c] != 0)
					return b[r][c];
			}
		}
		return 0;
	}
	/**
     * Where are the tokens that determine who the winner is?
     * @return the locations of the pieces that determine the game winner.
     */
	public Position[] getWinningPositions() {
		Position[] p = new Position[4];
		int [][] b = getBoard();
		//horizontal
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 4; c++) {
				if(b[r][c] == b[r][c+1] && b[r][c] == b[r][c+2] && b[r][c] == b[r][c+3] && b[r][c] != 0) {
					p[0] = new Position(r,c);
					p[1] = new Position(r,c+1);
					p[2] = new Position(r,c+2);
					p[3] = new Position(r,c+3);
					return p;
				}
			}
		}
		//vertical
		for (int c=0; c<7;c++) {
			for (int r = 5; r>=3; r--) {
				if(b[r][c] == b[r-1][c] && b[r][c] == b[r-2][c] && b[r][c] == b[r-3][c] && b[r][c] != 0) {
					p[0] = new Position(r,c);
					p[1] = new Position(r-1,c);
					p[2] = new Position(r-2,c);
					p[3] = new Position(r-3,c);
					return p;
				}
			}
		}
		//diagonal /
		for (int r=3; r<6; r++) {
			for (int c=0; c< 4; c++) {
				if(b[r][c] == b[r-1][c+1] && b[r][c] == b[r-2][c+2] && b[r][c] == b[r-3][c+3] && b[r][c] != 0) {
					p[0] = new Position(r,c);
					p[1] = new Position(r-1,c+1);
					p[2] = new Position(r-2,c+2);
					p[3] = new Position(r-3,c+3);
					return p;
				}
			}
		}
		//diagonal \
		for (int r=5; r>=3; r--) {
			for (int c=6; c>=3; c--) {
				if(b[r][c] == b[r-1][c-1] && b[r][c] == b[r-2][c-2] && b[r][c] == b[r-3][c-3] && b[r][c] != 0) {
					p[0] = new Position(r,c);
					p[1] = new Position(r-1,c-1);
					p[2] = new Position(r-2,c-2);
					p[3] = new Position(r-3,c-3);
					return p;
				}	
			}
		}
		return null;
	}
	/**
     * Does the column have room for an additional move?
     * @param column the column number
     * @return false if there is room for another move in the column, true if not.
     */
	public boolean columnFull(int column) {
		int[][] b = getBoard();
		if(b[0][column] != 0)
			return true;
		else {
			return false;
		}
	}
	/**
     * Change the game to reflect the current player placing a piece in the column.
     * @param column the column number
     */
	public void play(int column) {
		int[][] b = getBoard();
		int r = b.length - 1;
		while(b[r][column] > 0) {
			r--;
		}
		if(r >= 0)
			b[r][column] = currentPlayer;
		if(currentPlayer == 1)
			currentPlayer = 2;
		else
			currentPlayer = 1;
	}	
	/**
	 * The getBoard method returns a 2-dimensional array with the complete board configuration, with an array element being:
	 * 1 if the board position contains a token from the first player.
	 * 2 if the board position contains a token from the second player.
	 * 0 if the board position contains no tokens at all.
	 */
	public int[][] getBoard() {
		return board;
	}
	
}
