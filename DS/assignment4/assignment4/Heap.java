package assignment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Heap<E> {

	List<Jobs> jobs = new ArrayList<Jobs>();

	public void insertJobs(Scanner scan) {
		Jobs job = new Jobs();
		System.out.println("Enter the type of job");
		System.out.println("1 : Under Graduates");
		System.out.println("2 : Graduates");
		System.out.println("3 : Proffesors");
		System.out.println("4 : Chairman");
		int pri = scan.nextInt();
		job.setPriority(pri);
		jobs.add(job);
		buildHeap();
		scan.nextLine();
	}

	public void buildHeap() {
		if (jobs.isEmpty()) {
			System.out.println("No Jobs \nReady To Print Again!! \n");
		} else {
			for (int i = jobs.size() / 2 - 1 ; i >= 0; i--) {
				heapify(i);
			}
		}
	}

	public void heapify(int index) {
		
		Jobs temp;
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int largest = index;
		if (left < jobs.size() && jobs.get(left).compareTo(jobs.get(index)) > 0) {
			largest = left;
		} else {
			largest = index;
		}
		if (right < jobs.size()
				&& jobs.get(right).compareTo(jobs.get(index)) > 0) {
			largest = right;
		}
		if (largest != index) {
			temp = jobs.get(largest);
			jobs.set(largest, jobs.get(index));
			jobs.set(index, temp);
			heapify(largest);
		}
	}

	public void printService() {
		if (jobs.isEmpty()) {
			System.out.println("No Jobs Available");
		} else {
			while (!jobs.isEmpty()) {
				System.out.println(jobs.get(0).getName()
						+ " is getting printed ... \n");
				Jobs temp = jobs.get(jobs.size() - 1);
				jobs.set(0, temp);
				jobs.remove(jobs.size() - 1);
				buildHeap();
			}
		}
	}
}
