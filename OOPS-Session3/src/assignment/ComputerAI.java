package assignment;

public class ComputerAI {
	private char symbol;
	public ComputerAI(char symbol) {
		this.symbol = symbol;
	}

	public void makePlay() {
		System.out.println("Computer plays : ");
		System.out.println("");
		int randrow = (int) (Math.random() * 10) % 3;
		int randcol = (int) (Math.random() * 10) % 3;
		RuleCheck.checkLocation(randrow, randcol);
		while(RuleCheck.isLocation()){
			 randrow = (int) (Math.random() * 10) % 3;
			 randcol = (int) (Math.random() * 10) % 3;
			 RuleCheck.checkLocation(randrow, randcol);
		}
		State.setGrid(randrow, randcol, symbol);
		RuleCheck.checkWinner(randrow, randcol, symbol);
	}
}
