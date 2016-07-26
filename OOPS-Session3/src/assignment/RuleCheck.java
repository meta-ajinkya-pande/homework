package assignment;

public class RuleCheck {
	private static boolean win =false;
	private static boolean location=false;
	/**
	 * @return the win
	 */
	public static boolean isWin() {
		return win;
	}
	/**
	 * @param win the win to set
	 */
	public static void setWin(boolean win) {
		RuleCheck.win = win;
	}
	/**
	 * @return the location
	 */
	public static boolean isLocation() {
		return location;
	}
	
	/**
	 * @param location takes the location as true or false to set that location is valid for play or not
	 */
	public static void setLocation(boolean location) {
		RuleCheck.location = location;
	}
	
	/**
	 * 
	 * @param row takes row position from from where it should check the grid to check win condition
	 * @param col takes column position from where it should check the grid to check win condition
	 * @param symbol defines which player win the game
	 */
	public static void checkWinner(int row,int col,char symbol){
		if(checkRightDiagonal(symbol) || checkleftDiagonal(symbol) || checkHorizonttal(row,col,symbol) || checkVertical(row,col,symbol)){
			RuleCheck.setWin(true);
		}else {
			RuleCheck.setWin(false);
		}
	}
	
	/**
	 * 
	 * @param row takes row position from where it should check the grid to check vertical condition
	 * @param col takes column position from where it should check the grid to check vertical condition
	 * @param symbol takes which player it is checking for
	 * @return true or false according to condition Vertical check from location row and column
	 */
	private static boolean checkVertical(int row, int col,char symbol) {
		for(int i=0;i<3;i++){
			if(State.getGridContent(i, col) != symbol){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param row takes row position from where it should check the grid to check horizontal condition
	 * @param col takes column position from where it should check the grid to check horizontal condition
	 * @param symbol takes which player it is checking for
	 * @return true or false according to condition horizontal check from location row and column
	 */
	private static boolean checkHorizonttal(int row, int col,char symbol) {
		for(int i=0;i<3;i++){
			if(State.getGridContent(row, i) != symbol){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param symbol takes which player it is checking for.
	 * @return true or false according to condition left diagonal check from location row and column
	 */
	private static boolean checkleftDiagonal(char symbol) {
		for(int i=0,j=0;i<3 && j<3;i++,j++){
			if(State.getGridContent(i, j) != symbol){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param symbol takes which player it is checking for.
	 * @return true or false according to condition right diagonal check from location row and column
	 */
	private static boolean checkRightDiagonal(char symbol){
		for(int i=0,j=2;i<3 && j>=0;i++,j--){
			if(State.getGridContent(i, j) != symbol){
				return false;
			}
		}
		return true;
	}
	/**
	 * 
	 * @param row takes row location where it should check black location in the grid
	 * @param col takes column location where it should check black location in the grid
	 */
	public static void checkLocation(int row,int col){
		if(State.getGridContent(row, col) == ' '){
			RuleCheck.setLocation(false);
		}
		else{
			RuleCheck.setLocation(true);
		}
	}
}
