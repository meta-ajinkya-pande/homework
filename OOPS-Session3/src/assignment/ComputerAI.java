package assignment;

public class ComputerAI {
	private char symbol;
	private int[] freelocation;

	public ComputerAI(char symbol) {
		this.symbol = symbol;
		freelocation = new int[9];
	}

	public void makePlay() {
		setFreeLocation();
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

	public void setFreeLocation() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (State.getGridContent(row, col) == ' ') {
					freelocation[row * 3 + col] = 1;
				} else {
					freelocation[row * 3 + col] = 0;
				}
			}
		}
	}

}
