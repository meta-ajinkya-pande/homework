package assignment1;

public class DemoSingleLinkList {
	public static void main(String ar[]){
		SingleLinkedList<Integer> ll = new SingleLinkedList<Integer>();
		ll.add(20);
		int i =ll.remove(0);
		ll.add(21);
		ll.add(22);
		boolean val = ll.contains(22);
		ll.add(25);
		ll.add(2, 23);
		int j = ll.remove(3);
		ll.add(24);
		ll.removeByValue(24);
		ll.printLinkedList();
		ll.reverse();
		System.out.println("D: "+i+" "+j+" "+val);
		ll.printLinkedList();
	} 
}
