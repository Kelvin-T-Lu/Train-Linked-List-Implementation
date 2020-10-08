import java.util.Iterator;
/**
 * A train object that is an Iterable with Cars. 
 *
 */
class Train implements Iterable<Car> {
	/**
	 * The header and tail of the Car chain. 
	 */
	private Car header, tail;
	/**
	 * Name of the train. 
	 */
	private String name; 

	/**
	 * A train object with a string name. 
	 * @param name Name of the train object. 
	 */
	public Train(String name) {
		this.name = name; 
	}
	
	/**
	 * Name of the train. 
	 * @return Name of current object. 
	 */
	public String getName() {
		return this.name; 
	}
	
	/**
	 * An iterator for the implemented Iterable interface.
	 * @return An iterator that goes through all of the connected cars. 
	 */
	public Iterator<Car> iterator() {
		//returns an iterator which traverses
		//the train from the first car (the one closest
		//to the front of the train) to the last car
		//use an anonymous class here
		//required iterator methods: next() and hasNext()
		//both methods are required to work in O(1) time
		return new Iterator<Car>() {
			Car currentNode = header;
			boolean flag = false; //Use to check if header is called.
						
			public boolean hasNext() {
				//Empty train
				if(header== null) {
					return false; 
				}
				//Calls header first for hasNext. 
				if(!flag && currentNode != null) {
					return true; 
				}
				return (currentNode.getNext()!= null); 
			}
			
			public Car next() {
				//Ensures the first Node is printed. 
				if(!flag) {
					flag = true; 
					return currentNode; 
				}
				currentNode = currentNode.getNext(); 
				return currentNode; 
			}
		};
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object o) {
		//two trains are equal if they have the same name
		//O(1)
		if(name.equals((((Train)o).getName()))) {
			return true; 
		}
		return false;
	}
	
	/**
	 * Connect Car C to train iterable. 
	 * @param c The car being connected. 
	 */
	public void connectCar(Car c) {
		//When list is empty
		if(header== null) { 
			header = c;
			
			//Sets Tail
			setTail(c);
		}
		//When list is not empty
		else {
			//Connects Car
			c.setPrevious(tail);
			tail.setNext(c);
			
			//Sets the tail
			setTail(c);
		}
	}
	
	/** 
	 * Iterate throughs a linked node and assigns the tail. 
	 * @param start The starting index of the iterator. 
	 */
	private void setTail(Car start){
		Car temp = start; 
		
		while(temp.getNext()!= null) {
			temp = temp.getNext(); 
		}
		tail = temp; 
	}
	
	/**
	 * Disconnects a car from a train object. 
	 * @param c The car that is being disconnected. 
	 * @return The car node that is being disconnected. 
	 */
	public Car disconnectCar(Car c) {
		
		Car temp = search(c);//The car that is being removed. 
		if(temp == null) {
			throw new RuntimeException("Can not disconnect a car that doesn't exist"); 
		}
		
		//If car is at the beginning of train.
		if(header.equals(temp)) {
			header = null; 
			tail = null; 
			return temp;
		}
		this.tail = temp.getPrevious(); 
		
		tail.setNext(null);
		temp.setPrevious(null); 
		return temp;
	}
	
	/**
	 * Searches for a particular car inside the train. 
	 * @param c The car that is being searched for inside the train.
	 * @return The reference to the car being searched.  
	 */
	private Car search(Car c) {
		
		for(Car i: this) {
			if(i.equals(c)) {
				return i; 
			}
		}
		return null;
	}
	
	/**
	 * Reverses the car order in a train. Header and tail Car switch positions, middle cars will swap.
	 */
	public void reverseTrain() {
		//Empty train or 1 car element. 
		if(header == null || header.equals(tail)) {
			return; 
		}
		//Sets the iterator variable. 
		Car current = header; 
		
		//Reverses the original header. 
		current.setPrevious(current.getNext());
		current.setNext(null);
		Car temp = current; 
		current = current.getPrevious();
		 
		//Reverses middle Cars. 
		while(current != tail) {
			current.setPrevious(current.getNext());
			current.setNext(temp);
			temp = current; 
			current = current.getPrevious(); 
		}
		
		//Sets up the new header; Tail in original. 
		current.setPrevious(null);
		current.setNext(temp);
		header = current; 
		setTail(header); 
		
		
	}
	
	//example test code... edit this as much as you want!
	/**
	 * Test method for Train class. 
	 * @param args Arguments for train class. 
	 */
	public static void main(String[] args) {
		/*Car c1 = new Car("C1");
		Car c2 = new Car("C2");
		
		c1.setNext(c2);
		c2.setPrevious(c1);
		
		Train t1 = new Train("T1");
		Train t1b = new Train("T1");
		
		if(t1.getName().equals("T1") && t1.equals(t1b)) {
			System.out.println("Yay 1");
		}
		
		t1.printAscii();
		
		t1.connectCar(c1);
		t1.printAscii();
		
		Car c3 = new Car("C3");
		Car c4 = new Car("C4");
		
		c3.setNext(c4);
		c4.setPrevious(c3);
		
		t1.connectCar(c3);
		t1.printAscii();
		
		t1.disconnectCar(c2);
		t1.printAscii();
		
		t1.reverseTrain();
		t1.printAscii();
		*/
		//Own testing
		Train testing1 = new Train("T1");
		Car test1 = new Car("C0");
		Car test2 = new Car("C1");
		Car test3 = new Car("C3");
		
		testing1.connectCar(test1);
		testing1.connectCar(test2);
		testing1.connectCar(test3);
		
		testing1.printAscii();
		testing1.disconnectCar(test3);
		testing1.printAscii();
		
	}
	
	//*****************************************************************/
	//****************** DO NOT EDIT BELOW THIS LINE ******************/
	//*****************************************************************/
	/**
	 * Return the name of the train and its connected cars.
	 * @return The printed version of the train.  
	 */
	public String toString() {
		String s = getName();
		for(Car c : this) {
			s += " " + c;
		}
		return s;
	}
	/**
	 * The printed version of the train. 
	 */
	public void printAscii() {
		/*
		From: http://www.ascii-art.de/ascii/t/train.txt
		    o O___ _________
		  _][__|o| |O O O O|
		 <_______|-|_______|
		  /O-O-O     o   o  
		*/
		
		System.out.print(String.format("%-4s",getName())+"o O___");
		for(Car c : this) {
			System.out.print(" _________");
		}
		System.out.println();
		
		System.out.print("  _][__|o|");
		for(Car c : this) {
			System.out.print(" | "+String.format("%-5s",c.getName())+" |");
		}
		System.out.println();
		
		System.out.print(" |_______|");
		for(Car c : this) {
			System.out.print("-|_______|");
		}
		System.out.println();
		
		System.out.print("  /O-O-O  ");
		for(Car c : this) {
			System.out.print("   o   o  ");
		}
		System.out.println();
	}
}