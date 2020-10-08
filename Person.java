/**
 * A person class object with an assigned car. 
 */
class Person {
	/**
	 * Person's name. 
	 */
	private String name;
	/**
	 * The car the person is currently in.
	 */
	private Car currentCar; 
	
	/**
	 * A person object. 
	 * @param name The name of a person.
	 * @param currentCar The Car that a person is currently in. 
	 */
	public Person(String name, Car currentCar) {
		this.name = name;
		this.currentCar = currentCar;
	}
	
	/**
	 * Return the name of the person.
	 * @return Return the name of the person. 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the current car the Person is in.
	 * @return Return current car person is in. 
	 */
	public Car getCurrentCar() {
		return this.currentCar;
	}
	
	/**
	 * Moves person to adjacent car if possible. 
	 * @param c The car that the person is moving to. 
	 * @return Boolean flag if movement is possible. 
	 */
	public boolean moveToCar(Car c) {
		//Checks previous
		if(currentCar.getPrevious()!= null) {
			if(currentCar.getPrevious().equals(c)) {
				this.currentCar = c; 
				return true;
			}
		}
		//Checks next 
		if(currentCar.getNext()!= null) {
			if(currentCar.getNext().equals(c)) {
				this.currentCar = c; 
				return true; 
			}
		}
		
		return false;
	}
	
	/** 
	 * Return if two people are the same based on name. 
	 * @param o The name of the person being compared. 
	 * @return Boolean flag if two people are the same person. 
	 */
	public boolean equals(Object o) {
		if(getName().equals(((Person) o).getName())) {
			return true;
		}
		//two people are "equal" if they have the same name
		//O(1)
		return false;
	}

	/**
	 * Returns a person's name. 
	 * @return The name of a person object. 
	 */
	public String toString() {

		return getName();
	}
	
	//example test code... edit this as much as you want!
	/**
	 * Test method for Person's class. 
	 * @param args The arguments string array. 
	 */
	public static void main(String[] args) {
		Car c1 = new Car("C1");
		Car c2 = new Car("C2");
		Car c3 = new Car("C3");
		
		c1.setNext(c2);
		c2.setPrevious(c1);
		
		Person p1 = new Person("P1", c1);
		
		if(p1.getCurrentCar().equals(c1) && p1.getName().equals("P1")) {
			System.out.println("Yay 1");
		}
		
		if(p1.moveToCar(c2) && p1.getCurrentCar().equals(c2) && p1.moveToCar(c1) && p1.getCurrentCar().equals(c1)) {
			System.out.println("Yay 2");
		}
		
		Person p1b = new Person("P1", c1);
		if(p1.equals(p1b) && !p1.equals(new Person("P2", c1))) {
			System.out.println("Yay 3");
		}
	}
}