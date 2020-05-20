
public class Position {
	private int row;
	private int col;
	/**
	 * constructor
	 * @param r
	 * @param c
	 */
	public Position(int r, int c) {
		row = r;
		col = c;
	}
	/**
	 * constructor
	 */
	public Position() {
		row = 0;
		col = 0;
	}
	/**
	 * Accessory method for private instance variable col
	 * @return col
	 */
	public int getColumn() {
		return col;
	}
	/**
	 * Accessory method for private instance variable row
	 * @return row 
	 */
	public int getRow() {
		return row;
	}
	/**
	 * mutator method - sets private instance variable col to the given parameter
	 * @param integer a
	 */
	public void setCol(int a) {
		col = a;
	}
	/**
	 * mutator method - sets private instance variable row to the given parameter
	 * @param integer b
	 */
	public void setRow(int b) {
		row = b;
	}
	/**
	 * @param Object other
	 * @return true of false depending on if an object is equal to a position 
	 * override of the equals method to compare to positions
	 */
	public boolean equals(Object other) {
		if (other instanceof Position) {
			Position p = (Position)other;
			if(p.getRow() == this.row && p.getColumn() == this.col)
				return true;
			else
				return false;
		}
		return false;
	}
}
