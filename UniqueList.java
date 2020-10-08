import java.util.Iterator;

/**
 * A linked list with generics where each element is unique.
 * @param <T> The data type of list. 
 */
class UniqueList<T> implements Iterable<T> {
	
	/** 
	 * A node for the linked list in this class. 
	 * @param <T> The data type for a list. 
	 */
	private class Node<T> {
		/**
		 * The data contained in the node. 
		 */
		private T data;
		/**
		 * Returns the data contained in the node. 
		 * @return The data inside current node.
		 */
		public T getData() {
			return data;
		}
		
		/**
		 * The next node. 
		 */
		private Node next; 
		
		/**
		 * Return the next node.
		 * @return The next node in the list. 
		 */
		public Node getNext() { 
			return next; 
		}
		/**
		 * Sets the next node in the list. 
		 * @param next The next node in the list. 
		 */
		public void setNext(Node next) { 
			this.next = next;  
		}
		/**
		 * A Node with an assigned data type. 
		 * @param data The data of the Node.
		 */
		public Node(T data){
			this.data = data; 
		}
	}
	
	/**
	 * The header of this linked list. 
	 */
	private Node<T> header; 
	/**
	 * The tail of the linked list. 
	 */
	private Node<T> tail; 
	
	/**
	 * The size of the list. 
	 */
	private int size = 0; 
	
	/**
	 * Add's an item to the end of the list. 
	 * @param value The value that is being stored at the end of the list.
	 * @return If method was sucessful. 
	 */
	public boolean append(T value) { 
		//adds an item to the list at the end
		//Empty list
		if(size == 0) {
			header = new Node<T>(value);
			tail = header; 
			size++;
			return true; 
		}
		else { //Filled list
			if(contains(value)) { //Checks if value is inside.
				return false; 
			}
			//App ends items. 
			tail.setNext(new Node<T>(value));
			tail = tail.getNext(); 
			size ++;
			return true; 
		}
		//returns false if the value can not be added
		//(i.e. the value already exists in the list)
		
		//O(n) worst case, where n = the number of items
		//because you need to check for duplicates!
		
		//return false;
	}
	
	/**
	 * Removes a certain value from the list. 
	 * @param value The value that's being removed. 
	 * @return Whether the operation was sucessful. 
	 */
	public boolean remove(T value) {
		//remove a value from the list
		
		//return false if the item could not be found
		//return true if you remove the item
		
		//O(n) worst case, where n = the number of items
		if(contains(value)) {
			Node<T> current = header;
			Node<T> temp = current;
			
			//Iterates through the Nodes, temp is the node before the Node with value.
			while(!current.getData().equals(value)) {
				temp = current; 
				current = current.getNext();
			}
			size--;
			temp.setNext(current.getNext()); 
			return true;
		}
		
		return false;
	}
	
	/**
	 * Gets a value from the list and returns it. 
	 * @param value The value that is being returned from the list. 
	 * @return The value that is found inside the lsit. 
	 */
	public T get(T value) {
		for(T o: this) {
			if(o.equals(value)) {
				return o; 
			}
		}
		return null;
	}
	/**
	 * Checks whether if the list contains the value in one of the nodes. 
	 * @param value The value that is being searched for. 
	 * @return Whether the value is found inside the search. 
	 */
	public boolean contains(T value) {
		//return true if the item can be found in the
		//list, reuse code from get() to implement this
		//method
		for(T o: this) {
			if(o.equals(value)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Return the size of the list. 
	 * @return Size of the list. 
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Makes a clone of the current Unique List object. 
	 * @return A clone of the current Unique List with a different reference value. 
	 */
	public UniqueList<T> clone() {
		UniqueList<T> temp = new UniqueList<T>();
		for(T o: this) {
			temp.append(o);
		}
		
		return temp; 
	}
	/**
	 * {@inheritDoc}
	 */
	public Iterator<T> iterator() {
		
		return new Iterator<T>(){
			private Node<T> currentNode = header;
			private boolean flag = false; //Flag if header has been called. 
			public boolean hasNext() {
				//Empty list.
				if(header==null) {
					return false; 
				}
				//Header as first element. 
				if(!flag && header!=null) {
					return true;
				}
				return (currentNode.getNext()!=null);
			}
			public T next() {
				//Header is he first element iterated. 
				if(!flag && header!=null) {
					flag = true; 
					return currentNode.getData();
				}
				//All other elements. 
				currentNode = currentNode.getNext();
				return currentNode.getData();
			}
		};
	}

	/**
	 * Tester for Unique list. 
	 * @param args Arguments for UniqueList class. 
	 */
	public static void main(String[] args) {
		UniqueList<String> names = new UniqueList<>();
		
		if(names.append("Fred") && names.append("Alex") && !names.append("Fred")) {
			System.out.println("Yay 0");
		}
		
		if(names.size() == 2 && names.contains("Fred") && names.get("Alex").equals("Alex")) {
			System.out.println("Yay 1");
		}
		
		if(names.remove("Alex") && names.size() == 1 && names.get("Alex") == null) {
			System.out.println("Yay 2");
		}
		
		boolean hasEverything = false;
		for(String name : names) {
			if(hasEverything) {
				hasEverything = false;
				break;
			}
			
			hasEverything = name.equals("Fred");
		}
		if(hasEverything) {
			System.out.println("Yay 3");
		}
		/**
		 * A nested class, a cat object.
		 */
		class Cat {
			/**
			 * String name of a cat. 
			 */
			String name;
			/**
			 * A cat object. 
			 * @param name Name of cat. 
			 */
			public Cat(String name) { this.name = name; }
			/**
			 * {@inheritDoc}
			 */
			public boolean equals(Object o) {
				if(o instanceof Cat) {
					Cat c = (Cat)o;
					return c.name.equals(this.name);
				}
				return false;
			} 
		}
		
		UniqueList<Cat> catSet1 = new UniqueList<>();
		catSet1.append(new Cat("Sammy"));
		catSet1.append(new Cat("Grouchy"));
		UniqueList<Cat> catSet2 = catSet1.clone();
		if(catSet1 != catSet2 && catSet1.size() == catSet2.size()) {
			int matched = 0;
			for(Cat c : catSet1) {
				if(catSet2.get(c) == c) matched++;
			}
			if(matched == 2) {
				System.out.println("Yay 4");
			}
		}
	}
}