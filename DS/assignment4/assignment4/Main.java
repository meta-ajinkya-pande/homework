package assignment4;

import java.util.Scanner;

public class Main {

	public static void main(String[] ar) {
		Heap<Jobs> obj = new Heap<Jobs>();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("Enter your choice");
			System.out.println("1: Insert Jobs");
			System.out.println("2: PRint service call");
			System.out.println("3: exit");
			int choice = scan.nextInt();
			if(choice ==1)
				obj.insertJobs(scan);
			else if(choice == 2)
				obj.printService();
			else if (choice == 3) {
				break;
			}
			else{
				System.out.println("\nEnter correct choice\n");
			}
		}
		scan.close();
	}
}
