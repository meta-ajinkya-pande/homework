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
	 * @param location the location to set
	 */
	public static void setLocation(boolean location) {
		RuleCheck.location = location;
	}
	
	public static void checkWinner(int row,int col,char symbol){
		if(checkRightDiagonal(symbol) || checkleftDiagonal(symbol) || checkHorizonttal(row,col,symbol) || checkVertical(row,col,symbol)){
			RuleCheck.setWin(true);
		}else {
			RuleCheck.setWin(false);
		}
	}
	
	private static boolean checkVertical(int row, int col,char symbol) {
		for(int i=0;i<3;i++){
			if(State.getGridContent(i, col) != symbol){
				return false;
			}
		}
		return true;
	}

	private static boolean checkHorizonttal(int row, int col,char symbol) {
		for(int i=0;i<3;i++){
			if(State.getGridContent(row, i) != symbol){
				return false;
			}
		}
		return true;
	}

	private static boolean checkleftDiagonal(char symbol) {
		for(int i=0,j=0;i<3 && j<3;i++,j++){
			if(State.getGridContent(i, j) != symbol){
				return false;
			}
		}
		return true;
	}

	private static boolean checkRightDiagonal(char symbol){
		for(int i=0,j=2;i<3 && j>=0;i++,j--){
			if(State.getGridContent(i, j) != symbol){
				return false;
			}
		}
		return true;
	}
	
	public static void checkLocation(int row,int col){
		if(State.getGridContent(row, col) == ' ' || State.getGridContent(row,col) == 'X'
			|| State.getFridContent(row,col) == 'O'){
			RuleCheck.setLocation(false);
		}
		else{
			RuleCheck.setLocation(true);
		}
	}
}
