package assignment;

import java.util.Scanner;

public class Player {
	
	private char symbol;
	
	public Player(char symbol){
		this.symbol =symbol;
	}
	// Returning the player name
	public String playerName(){
		return "Player "+symbol;
	}
	
	public void makeMove(Scanner sc){
		System.out.println(playerName() + " chance to play:");
		System.out.println();
		System.out.println("Enter the row");
		int row =sc.nextInt();
		System.out.println("Enter the col");
		int col = sc.nextInt();
		while(RuleCheck.isLocation()){
			// Checking that grid[row][col] is empty or not
				System.out.println("Please Enter correct row and col");
				System.out.println("Enter row:");
				row = sc.nextInt();
				System.out.println("Enter col:");
				col = sc.nextInt();
				RuleCheck.checkLocation(row,col);
		}
		State.setGrid(row, col, symbol);
		RuleCheck.checkWinner(row, col, symbol);
	}
}