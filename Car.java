/**
 * A car class object for Train Simulator. 
 */
class Car {
	/** 
	 * Name of the car object.
	 */
	private String name;
	/**
	 * The previous car that this car is connected to.
	 */
	private Car prev;
	/**
	 * The car the is connected after this car.
	 */
	private Car next; 
	/**
	 * A car object with a name. 
	 * @param name The name of the car object. 
	 */
	public Car(String name) {
		this.name = name; 
	}
	
	/**
	 * Returns the next car that's connected to this car. 
	 * @return Car object linked after current car object.
	 */
	public Car getNext() {
		return this.next;
	}
	
	/**
	 * Returns the car that this car is linked to. 
	 * @return	Car object that is being linked to by current car. 
	 */
	public Car getPrevious() {
		return this.prev;
	}
	
	/**
	 * Sets the car after this one to this car. 
	 * @param next The car that's being connected to current car object.
	 */
	public void setNext(Car next) {
		this.next = next;//sets the car after this one to next (the parameter)
	}

	/**
	 * Sets the car that' this car is being connected to.
	 * @param previous The linked car before this current car.
	 */
	public void setPrevious(Car previous) {

		this.prev = previous; 
	}
	
	/**
	 * Returns the current car's name.
	 * @return Current car's name. 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object o) {
		//two cars are equal if they have the same name
		//O(1)
		return this.name.equals(((Car) o).getName());
	}
	
	/**
	 * {@inheritDoc} 
	 */
	public String toString() {
		return getName(); 
	}
	
	//example test code... edit this as much as you want!
	/**
	 * Tester for the Car class. 
	 * @param args The arguments when running this class. 
	 */
	public static void main(String[] args) {
		Car c1 = new Car("C1");
		Car c2 = new Car("C2");
		
		c1.setNext(c2);
		c2.setPrevious(c1);
		
		if(c1.getName().equals("C1")) {
			System.out.println("Yay 1");
		}
		
		if(c1.getNext().equals(c2) && c2.getPrevious().equals(c1)) {
			System.out.println("Yay 2");
		}
		
		Car c1b = new Car("C1");
		if(c1.equals(c1b)) {
			System.out.println("Yay 3");
		}
		
		c1.printAscii();
	}
	
	//*****************************************************************/
	//****************** DO NOT EDIT BELOW THIS LINE ******************/
	//*****************************************************************/
	/**
	 * Print the picture version of a Car. 
	 */
	public void printAscii() {
		/*
		From: http://www.ascii-art.de/ascii/t/train.txt
		 _________
		 |O O O O|
		-|_______|
		   o   o  
		*/
		
		Car current = this;
		while(current != null) {
			System.out.print(" _________");
			current = current.getNext();
		}
		System.out.println();
		
		current = this;
		while(current != null) {
			System.out.print(" | "+String.format("%-5s",current.getName())+" |");
			current = current.getNext();
		}
		System.out.println();
		
		current = this;
		while(current != null) {
			System.out.print("-|_______|");
			current = current.getNext();
		}
		System.out.println();
		
		current = this;
		while(current != null) {
			System.out.print("   o   o  ");
			current = current.getNext();
		}
		System.out.println();
	}
}