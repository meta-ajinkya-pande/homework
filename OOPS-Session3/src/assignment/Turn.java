package assignment;

public class Turn {
	private static int playerTurn;
	private static int turnCount;

	/**
	 * @return the playerTurn
	 */
	public static int getPlayerTurn() {
		return playerTurn;
	}

	/**
	 * @param playerTurn the playerTurn to set
	 */
	public static void setPlayerTurn() {
		Turn.playerTurn = (++playerTurn)%2;
	}

	/**
	 * @return the turnCount
	 */
	public static int getTurnCount() {
		return turnCount;
	}
	
	/**
	 * @param turnCount the turnCount to set
	 */
	public static void setTurnCount() {
		turnCount++;
	}
}
