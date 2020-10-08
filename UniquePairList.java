/**
 * A unique list filled with Paired objects. 
 * @author Kilo Lima Uniform
 *
 * @param <K> Data type of Key. 
 * @param <V> Data type of Value. 
 */
class UniquePairList<K,V> {
	/**
	 * A pair object that has a key and a value. 
	 * @param <K> Data type for Key. 
	 * @param <V> Data type for Value. 
	 */
	private static class Pair<K,V> {
		/**
		 * The Object's key. 
		 */
		private K key; 
		/**
		 * The Object's value. 
		 */
		private V value; 
		
		/**
		 * A pair object with a key and value. 
		 * @param key The key of the object. 
		 * @param value The value of the object. 
		 */
		public Pair(K key, V value) {
			this.key = key;
			this.value = value; 
		}
		
		/**
		 * Checks if two pairs are equals based on their keys.
		 * @param o The object that's being compared.
		 * @return Return the boolean value if two objects are equal. 
		 */
		public boolean equals(Object o) {
			return ((K)o).equals(key);
		}
		
		/**
		 * {@inheritDoc}
		 */
		public String toString() {
			//this method is done for you
			return "<" + getKey() + "," + getValue() + ">";
		}
		
		/**
		 * Return the key inside the Pair. 
		 * @return The key inside the pair. 
		 */
		public K getKey() {
			return this.key;
		}
		
		/**
		 * Return the value of the Pair. 
		 * @return The value of the Pair object. 
		 */
		public V getValue() {
			return this.value; 
		}
	}
	
	//example test code... edit this as much as you want!
	/**
	 * Tester for the UniquePairList Class. 
	 * @param args Arguements for the Class. 
	 */
	public static void main(String[] args) {
		Pair<String,Integer> p1 = new Pair<>("Fred", 1);
		Pair<String,Integer> p2 = new Pair<>("Alex", 1);
		Pair<String,Integer> p3 = new Pair<>("Fred", 2);
		
		if(p1.getKey().equals("Fred") && p1.getValue() == 1 && p1.equals(p3)) {
			System.out.println("Yay 1");
		}
		
		if(!p1.equals(p2)) {
			System.out.println("Yay 2");
		}
		
		//this is actually a test of UniqueList, not UniquePairList
		UniqueList<Pair<String,Integer>> set = new UniqueList<>();
		set.append(p1);
		
		//get the value from the set that is _equal to_ p3 (in this case, p1)
		Pair<String,Integer> p1fromSet = set.get(p3);
		if(p1fromSet.getValue() == 1) {
			System.out.println("Yay 3");
		}
	}
	
	//*****************************************************************/
	//****************** DO NOT EDIT BELOW THIS LINE ******************/
	//********************* EXCEPT TO ADD JAVADOCS ********************/
	//*****************************************************************/
	
	/**
	 * The Unique List with Pair inside of it. 
	 */
	private UniqueList<Pair<K,V>> set = new UniqueList<>();
	
	/**
	 * Adds a Pair into the UniqueList. 
	 * @param key The Key for the pair. 
	 * @param value The value for the pair. 
	 * @return Whether if a method is sucessful. 
	 */
	public boolean append(K key, V value) {
		Pair<K,V> pair = new Pair<>(key, value);
		return set.append(pair);
	}
	
	/**
	 * Updates the list by removing a Pair with a certain key from the Unique List. 
	 * @param key The key of the pair. 
	 * @param value The value of the pair. 
	 * @return If the operation was sucessful. 
	 */
	public boolean update(K key, V value) {
		Pair<K,V> pair = new Pair<>(key, value);
		if(!remove(key)) {
			return false;
		}
		return set.append(pair);
	}
	
	/**
	 * Removes a pair from the Unique List if possible. 
	 * @param key The key of the Pair being removed. 
	 * @return If the operations was sucessful.
	 */
	public boolean remove(K key) {
		Pair<K,V> pair = new Pair<>(key, null);
		return set.remove(pair);
	}
	
	/**
	 * The value of the Pair from a key. 
	 * @param key The value of a pair from the key. 
	 * @return The value of a pair. 
	 */
	public V getValue(K key) {
		Pair<K,V> pair = new Pair<>(key, null);
		return set.get(pair).getValue();
	}
	
	/**
	 * Creates a list of keys based on the pair in Unique List. 
	 * @return A unique list of keys. 
	 */
	public UniqueList<K> getKeys() {
		UniqueList<K> keySet = new UniqueList<>();
		for(Pair<K,V> p : set) {
			keySet.append(p.getKey());
		}
		return keySet.clone();
	}
	
	/**
	 * The size of the Unique List with pairs.  
	 * @return The int representation of size. 
	 */
	public int size() {
		return set.size();
	}
}