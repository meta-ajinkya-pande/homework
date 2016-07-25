package assignment;

public class State {
	private static char grid[][];

	/**
	 * @return the grid
	 */
	public char[][] getGrid() {
		return grid;
	}

	/**
	 * @param grid the grid to set
	 */
	public void setGrid(int i ,int j,char symbol) {
		grid[i][j] = symbol;
	}
}
