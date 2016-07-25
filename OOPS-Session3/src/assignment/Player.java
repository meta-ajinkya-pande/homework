package assignment;

import java.util.Scanner;

public class Player {

	private char symbol;

	public Player(char symbol) {
		this.symbol = symbol;
	}

	// Returning the player name
	public String playerName() {
		return "Player " + symbol;
	}

	public void makeMove(Scanner sc) {
		System.out.println(playerName() + " chance to play:");
		System.out.println();
		try {
			System.out.println("Enter the row");
			String srow = sc.nextLine();
			
			// Validate the row is correct input or not
			srow = rowValidate(srow, sc);
			int row = Integer.parseInt(srow);
			
			System.out.println("Enter the col");
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
				srow = rowValidate(srow, sc);
				row = Integer.parseInt(srow);
				System.out.println("Enter col:");
				scol = sc.nextLine();
				scol = colValidate(scol, sc);
				col = Integer.parseInt(scol);
				RuleCheck.checkLocation(row, col);
			}
			State.setGrid(row, col, symbol);
			RuleCheck.checkWinner(row, col, symbol);
		} catch (Exception e) {}
	}
	
	private String rowValidate(String srow,Scanner sc){
		if (srow.length() > 1 || srow.codePointAt(0) <= 47
				|| srow.codePointAt(0) > 51) {
			while (true) {
				System.out.println("Enter correct row");
				srow = sc.nextLine();
				if (srow.length() == 1 || srow.codePointAt(0) > 47
						|| srow.codePointAt(0) <= 51) {
					break;
				}
			}
		}
		return srow;
	}
	
	private String colValidate(String scol , Scanner sc){
		if (scol.length() > 1 || scol.codePointAt(0) <= 47
				|| scol.codePointAt(0) > 51) {
			while (true) {
				System.out.println("Enter correct row");
				scol = sc.nextLine();
				if (scol.length() == 1 || scol.codePointAt(0) > 47
						|| scol.codePointAt(0) <= 51) {
					break;
				}
			}
		}
		return scol;
	}
}
