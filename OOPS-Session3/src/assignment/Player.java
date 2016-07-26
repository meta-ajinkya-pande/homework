package assignment;

import java.util.Scanner;
/**
 * 
 * @author Ajinkya Pande
 * @see if player makes moves then it call a method makeMove
 *
 */
public class Player {

	private char symbol;

	public Player(char symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return player name which player is playing
	 */
	public String playerName() {
		return "Player " + symbol;
	}

	/**
	 * @param sc is scanner which is used to take input.
	 */
	public void makeMove(Scanner sc) {
		System.out.println(playerName() + " chance to play:");
		System.out.println();
		try {
			System.out.println("Enter the row value(0-2)");
			String srow = sc.nextLine();
			
			// Validate the row is correct input or not
			srow = rowValidate(srow, sc);
			int row = Integer.parseInt(srow);
			
			System.out.println("Enter the col value(0-2)");
			String scol = sc.nextLine();
			
			// Validate the col is correct is not
			scol = colValidate(scol, sc);
			int col = Integer.parseInt(scol);

			RuleCheck.checkLocation(row, col);
			while (RuleCheck.isLocation()) {
				// Checking that grid[row][col] is empty or not
				System.out.println("Please Enter correct your location:");
				System.out.println("Enter row:");
				srow = sc.nextLine();
				srow = rowValidate(srow, sc);	// validate that it is correct or not
				row = Integer.parseInt(srow);
				System.out.println("Enter col:");
				scol = sc.nextLine();
				scol = colValidate(scol, sc); // validate that it is correct or not
				col = Integer.parseInt(scol);
				RuleCheck.checkLocation(row, col);
			}
			State.setGrid(row, col, symbol);
			RuleCheck.checkWinner(row, col, symbol);
		} catch (Exception e) {}
	}
	
	/**
	 * @param srow is the String type of row if user input wrong inputs then it should ask again until it gives correct input row
	 * @param sc is scanner object that takes the input from console
	 * @return valid String row 
	 */
	private String rowValidate(String srow,Scanner sc){
		if (srow.length() > 1 || srow.codePointAt(0) <= 47
				|| srow.codePointAt(0) > 51) {
			while (true) {
				System.out.println("Enter correct row");
				srow = sc.nextLine();
				if (srow.length() == 1 || srow.codePointAt(0) > 47
						&& srow.codePointAt(0) < 51) {
					break;
				}
			}
		}
		return srow;
	}
	
	/**
	 * @param scol is the String type of column if user input wrong inputs then it should ask again until it gives correct input column
	 * @param sc is scanner object that takes the input from console
	 * @return valid String column
	 */
	private String colValidate(String scol , Scanner sc){
		if (scol.length() > 1 || scol.codePointAt(0) <= 47
				|| scol.codePointAt(0) > 51) {
			while (true) {
				System.out.println("Enter correct col");
				scol = sc.nextLine();
				if (scol.length() == 1 || scol.codePointAt(0) > 47
						&& scol.codePointAt(0) < 51) {
					break;
				}
			}
		}
		return scol;
	}
}
