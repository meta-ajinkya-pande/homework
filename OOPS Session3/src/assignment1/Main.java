package assignment1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompositeMenu menu = new CompositeMenu();
		Scanner sc = new Scanner(System.in);
		menu.addList(menu);
		menu.setMenuName("Main");
		menu.setParent(null);
		menu.generateList(sc);
		menu.printList(0, sc);
	}

}
