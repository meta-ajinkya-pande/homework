/**
 * 
 */
package assignment;

import java.util.Scanner;

/**
 * @author Ajinkya pande
 *
 */
public class TikTacToc {
	public static void main(String ar[]){
		State.makeGridEmpty();
		Player[] p1 = new Player[2];
		p1[0] = new Player('X');
		p1[1] = new Player('O');
		while(Turn.getTurnCount() < 9){
			p1[Turn.getPlayerTurn()].makeMove(new Scanner(System.in));
			State.showGrid();
			if(RuleCheck.isWin()){
				System.out.println(p1[Turn.getPlayerTurn()].playerName() + " Wins !!!!");
				break;
			}
			Turn.setTurnCount();
			Turn.setPlayerTurn();
		}
	}
}
