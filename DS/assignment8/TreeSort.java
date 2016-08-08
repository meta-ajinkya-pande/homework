package assignment8;

import java.util.List;
import java.util.ArrayList;

public class TreeSort<E> {
	private Node<E> root;
	private List<E> sortedArray;
	/**
	 * insertion For Binary Tree
	 * @param data is value that is used to insert
	 * @param pivort is node from where you want to insert
	 */
	private void insert(E data, Node<E> pivort) {
		// Insert the value to the root if root is empty
		if (root == null) {
			root = new Node<E>();
			root.setElement(data);
			root.setLeft(null);
			root.setRight(null);
			return;
			// If element is less than root element then insert element to left
		} else if (data.toString().compareTo(pivort.getElement().toString()) < 0
				&& pivort.getLeft() == null) {
			Node<E> newnode = new Node<E>();
			newnode.setElement(data);
			newnode.setLeft(null);
			newnode.setRight(null);
			pivort.setLeft(newnode);
			return;
			// If element is less than root element then insert element to right
		} else if (data.toString().compareTo(pivort.getElement().toString()) >= 0
				&& pivort.getRight() == null) {
			Node<E> newnode = new Node<E>();
			newnode.setElement(data);
			newnode.setLeft(null);
			newnode.setRight(null);
			pivort.setRight(newnode);
			return;
			// If right and left node is not null of the root element then recursively call that method
		} else {
			if (data.toString().compareTo(pivort.getElement().toString()) < 0) {
				insert(data, pivort.getLeft());
			} else {
				insert(data, pivort.getRight());
			}
		}
	}
	
	public void addValue(E data){
		insert(data , root);
	}
	
	/**
	 * The inOrder traversal of the binary tree
	 * @param pivort is location of the root element in traversal
	 */
	private void inorder(Node<E> pivort){
		if(pivort != null){
			inorder(pivort.getLeft());
			sortedArray.add(pivort.getElement());
			inorder(pivort.getRight());
		}
	}
	
	/**
	 * This function sort the element using the inOrder traversal of the binary tree
	 * @return the list which contains sorted elements
	 */
	public List<E> sort(){
		sortedArray = new ArrayList<E>();
		inorder(root);
		return sortedArray;
	}
}
