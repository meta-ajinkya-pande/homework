package assignment;

public class State {
	private static char grid[][];

	/**
	 * @return the gridContent at location row and col
	 */
	public static char getGridContent(int row, int col) {
		return grid[row][col];
	}

	/**
	 * @param grid the grid to set
	 */
	public static void setGrid(int row ,int col,char symbol) {
		State.grid[row][col] = symbol;
	}
	
	/*
	 * To make whole grid empty
	 */
	public static void makeGridEmpty(){
		grid = new char[3][3];
		for(int row=0;row<grid.length;row++){
			for(int col=0;col<grid[row].length;col++){
				grid[row][col] = ' ';
			}
		}
	}
	/*
	 * To Print The Grid After every move.
	 */
	public static void showGrid(){
		for(int row=0;row<grid.length;row++){
			for(int col=0;col<grid[row].length;col++){
				System.out.print("|"+grid[row][col]+"|");
			}
			System.out.println("");
			System.out.println("---------");
		}
	}
}
