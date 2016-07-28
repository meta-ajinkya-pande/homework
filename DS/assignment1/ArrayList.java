package assignment1;

public class ArrayList<E> implements List<E> {

	private Object[] Array = null;
	private static int MAX = 5;

	// Constructor
	public ArrayList() {
		super();
		Array = new Object[MAX];
	}

	// To increase the size of an Array
	private void increaseArraySize() {
		MAX += 2;
		Object[] newArray = new Object[MAX];

		for (int i = 0; i < size(); i++) {
			newArray[i] = this.Array[i];
		}
		this.Array = newArray;
	}

	// to add an element in array
	@Override
	public boolean add(E element) {
		try {
			if (size() >= MAX / 2 + 1) {
				increaseArraySize();
			}
			this.Array[size()] = element;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// to add elements at position index
	@SuppressWarnings("unchecked")
	@Override
	public void add(int index, E element) {
		if (size() >= MAX / 2 + 1) {
			increaseArraySize();
		}
		E temp;
		for (int i = index; i < size(); i++) {
			temp = (E) this.Array[i];
			this.Array[i] = element;
			element = temp;
		}
	}

	// it clear the all elements of the list
	@Override
	public void clear() {
		Object[] newArray = new Object[5];
		this.Array = newArray;
	}

	// it checks where the object contains in array or not
	@Override
	public boolean contains(E o) {
		for (int i = 0; i < size(); i++) {
			if (o.equals(this.Array[i])) {
				return true;
			}
		}
		return false;
	}

	// return that list is empty or not
	@Override
	public boolean isEmpty() {
		for (int i = 0; i < size(); i++) {
			if (this.Array[i] != null) {
				return false;
			}
		}
		return true;
	}

	// Remove the element of location index
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		try{
		E removed = (E) this.Array[index];
		for (int i = index; i < size() - 1; i++) {
			this.Array[i] = this.Array[i + 1];
		}
		this.Array[size()-1] = null;
		return removed;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	// Return the no of elements present in a list
	@Override
	public int size() {
		int count = 0;
		for (@SuppressWarnings("unused")
		Object object : this.Array) {
			count++;
		}
		return count;
	}

	// return the object array
	@Override
	public Object[] toArray() {
		return this.Array;
	}

	@Override
	public int removeByValue(E value) {
		boolean flag = false;
		int index=0;
		for(int i=0;i<size()-1;i++){
			if(this.Array[i] == value){
				flag =true;
				index =i;
			}else if(flag){
				this.Array[i] = this.Array[i + 1];
			}
		}
		this.Array[size()-1] = null;
		return index;
	}

	@Override
	public void reverse() {
		Object[] reverseArray = new Object[size()];
		for(int i=size()-1;i>0;i--){
			reverseArray[(size()-1)%i] = Array[i];  
		}
		reverseArray[size()-1] = Array[0];
		Array = reverseArray;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getElement(int index) {
		return (E) Array[index];
	}
}
