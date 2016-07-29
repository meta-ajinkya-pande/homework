package assignment1;

import java.util.Comparator;

public class SingleLinkedList<E> implements List<E> {

	Node<E> first;
	Node<E> last;

	@Override
	public boolean add(E element) {
		try {
			Node<E> node = new Node<E>();
			node.setElement(element);
			node.setNext(null);
			if (isEmpty()) {
				first = node;
			} else {
				last.setNext(node);
			}
			last = node;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean add(int index, E element) {
		try {
			Node<E> node = new Node<E>();
			node.setElement(element);
			if (index > size()) {
				throw new IllegalArgumentException();
			}
			int counter = 0;
			Node<E> temp = first;
			while (counter < index - 1 && temp.getNext() != null) {
				temp = temp.getNext();
				counter++;
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void clear() {
		Node<E> temp = first;
		Node<E> temp1;
		while (temp != last) {
			temp1 = temp;
			temp.setElement(null);
			temp = temp.getNext();
			temp1.setNext(null);
		}
		temp.setElement(null);
		temp.setNext(null);
		first = null;
		last = null;
	}

	@Override
	public boolean contains(E o) {
		Node<E> node = new Node<E>();
		node.setElement(o);
		Node<E> temp = first;
		while (temp != null) {
			if (temp.getElement() == node.getElement()) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (first == null) {
			return true;
		}
		return false;
	}

	@Override
	public E remove(int index) {
		E temp = null;
		Node<E> node = first, temp1;
		if (index == 0) {
			temp = node.getElement();
			first = node.getNext();
		} else {
			int counter = 0;
			while (node.getNext() != null && counter < index - 1) {
				counter++;
				node = node.getNext();
			}
			if (index == size() - 1) {
				last = node;
			}
			temp1 = node.getNext();
			temp = temp1.getElement();
			node.setNext(temp1.getNext());
			temp1 = null;

		}
		return temp;
	}

	@Override
	public int size() {
		int counter = 0;
		Node<E> node = first;
		while (node != null) {
			node = node.getNext();
			counter++;
		}
		return counter;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[this.size()];
		Node<E> node = first;
		int index = 0;
		while (node != null) {
			array[index] = node.getElement();
			node = node.getNext();
		}
		return array;
	}

	public void printLinkedList() {
		Node<E> node = first;
		while (node != null) {
			System.out.println(node.getElement());
			node = node.getNext();
		}
	}

	@Override
	public int removeByValue(E value) {
		int index = 0;
		Node<E> node = first, prv = first;
		while (node != null) {
			if (node.getElement() == value) {
				if (index == 0) {
					first = first.getNext();
				} else if (index == size()-1 ) {
					last = prv;
					prv.setNext(null);
				} else {
					prv.setNext(node.getNext());
				}
				node = null;
				break;
			}
			prv = node;
			index++;
			node = node.getNext();
		}
		if (index > size()) {
			throw new IllegalArgumentException();
		}
		return index;
	}

	@Override
	public void reverse() {
		Node<E> prv, curr, next;
		prv = null;
		curr = first;
		last = first;
		next = first.getNext();
		while (curr.getNext() != null) {
			curr.setNext(prv);
			prv = curr;
			curr = next;
			next = next.getNext();
		}
		curr.setNext(prv);
		first = curr;
	}

	@Override
	public E getElement(int index) {
		if (index > size()) {
			throw new IllegalArgumentException();
		}
		Node<E> node = first;
		int counter = 0;
		E value;
		while (node.getNext() != null && counter < index) {
			node = node.getNext();
		}
		value = node.getElement();
		return value;
	}

	public boolean sort() {
		SingleLinkedList<E> sortedArray = new SingleLinkedList<E>();
		Comparator<E> c = new Comparator<E>() {
			@Override
			public int compare(E arg0, E arg1) {
				int last = arg0.toString().compareTo(arg1.toString());
				return last;
			}
		};
		mergeSort(0, size() - 1, sortedArray, c);
		return true;
	}

	private void mergeSort(int low, int high, SingleLinkedList<E> sortedArray,
			Comparator<E> c) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(low, mid, sortedArray, c);
			mergeSort(mid + 1, high, sortedArray, c);
			merge(low, mid, high, sortedArray, c);
		}
	}

	private void merge(int low, int mid, int high,
			SingleLinkedList<E> sortedArray, Comparator<E> c) {
		for (int i = low; i <= high; i++) {
			sortedArray.add(this.getElement(i));
		}
		int i = low;
		int j = mid + 1;
		int k = low;
		while (i <= mid && j <= high) {
			if (c.compare((E) sortedArray.getElement(j),
					(E) sortedArray.getElement(i)) > 0) {
				this.add(k, sortedArray.getElement(i));
				i++;
			} else {
				this.add(k, sortedArray.getElement(j));
				j++;
			}
			k++;
		}
		while (i <= mid) {
			this.add(k, sortedArray.getElement(i));
			k++;
			i++;
		}
	}

}
