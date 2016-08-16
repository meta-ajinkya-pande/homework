package assignment7;

import java.util.Scanner;
/**
 * This program is used to count the unique charters in the given string
 * and to implements caching into it.  
 * @author Ajinkya pande
 *
 */
public class UniqueCharaterMain {
	/**
	 * This is the main function of the counting unique charter in string  
	 * @param args is the String type of arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		UniqueCharater charactersCounter = new UniqueCharater();
		int userChoice;
		try {
			while (true) {
				// Asking for the choice
				System.out
						.println("Press \n 1: finding unique charater \n 2: exit");
				// getting the choice
				String choice = scan.nextLine();
				// verifying the choice is correct or not 
				if (choice.equals("1") || choice.equals("2")) {
					userChoice = Integer.parseInt(choice);
					// if user choice is 1 then it will enter the string
					if (userChoice == 1) {
						System.out.println("Enter String:");
						String inData = scan.nextLine();
						System.out.println("Unique charcters = "
								+ charactersCounter.countUniqueChar(inData));
					}
					// if user choice is 2 then it exits the program
					if (userChoice == 2) {
						break;
					}
				} else {
					System.out.println("Enter correct choice");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		scan.close();
	}
}
