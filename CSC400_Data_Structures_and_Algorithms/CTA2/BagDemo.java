
public class BagDemo {

	ShoppingCart cart;
	ShoppingItem item1;
	ShoppingItem item2;
	ShoppingItem item3;
	ShoppingItem item4;
	ShoppingItem item5;
	
	public BagDemo() {
		this.cart = new ShoppingCart(5);
		item1 = new ShoppingItem(0001, 2345, "Peanut Butter", 5.25);
		item2 = new ShoppingItem(0001, 6743, "Milk", 3.00);
		item3 = new ShoppingItem(0001, 2376, "Bananas", 2.50);
		item4 = new ShoppingItem(0001, 7412, "1lb Ground Beef", 6.75);
		item5 = new ShoppingItem(0001, 5819, "1lb Cheddar Cheese", 10.33);
		this.testEmptyAndFull();
		this.cart.add(item1);
	}
	
	public void displayBag() {
		
		ShoppingItem[] arr = this.cart.toArray(); 
		System.out.println("Bag Contents");
		System.out.println("---------------------------");
		for (ShoppingItem item : arr) {
			System.out.println(item);
		}
		System.out.println("---------------------------\n");		
	}
	
	public boolean testAdd(ShoppingItem item) {
		return this.cart.add(item);
	}
	
	public boolean testRemoveByItem(ShoppingItem item) {
		return this.cart.remove(item);
	}
	
	public ShoppingItem testRemoveFirstItem() {
		return this.cart.remove();
	}
	
	public int testGetFrequencyOf(ShoppingItem item) {
		return this.cart.getFrequencyOf(item);
	}
	
	public boolean testIsEmpty() {
		return this.cart.isEmpty();
	}
	
	public boolean testIsFull() {
		return this.cart.isFull();
	}
	
	public void testEmptyAndFull() {
		System.out.println("Is cart full? " + testIsFull());
		System.out.println("Is cart empty? " + testIsEmpty() + "\n");
	}
	
	public boolean testContains(ShoppingItem item) {
		return this.cart.contains(item);
	}
	
	public int testGetCurrentSize() {
		return this.cart.getCurrentSize();
	}
	 
	public static void main(String args[]) {
		
		BagDemo bd = new BagDemo();
		
		bd.displayBag();
		
		bd.testAdd(bd.item1);
		bd.testAdd(bd.item2);
		
		bd.displayBag();
		
		System.out.println("Frequency of Peanut Butter: " + bd.testGetFrequencyOf(bd.item1) + "\n");
		
		bd.testRemoveByItem(bd.item1);
		bd.displayBag();
		bd.testRemoveByItem(bd.item1);
		bd.displayBag();
		//extra remove does not throw exception
		bd.testRemoveByItem(bd.item1);
		bd.displayBag();
		
		bd.testEmptyAndFull();
		
		System.out.println("Current Size of Cart: " + bd.testGetCurrentSize() + "\n");
		System.out.println("Does cart contain Peanut Butter? : " + bd.testContains(bd.item1));
		System.out.println("Does cart contain Milk? : " + bd.testContains(bd.item2) + "\n");
		
		bd.testAdd(bd.item1);
		bd.testAdd(bd.item3);
		bd.displayBag();
		
		System.out.println("Current Size of Cart: " + bd.testGetCurrentSize() + "\n");
		
		bd.testAdd(bd.item4);
		bd.testAdd(bd.item5);
		bd.displayBag();
		
		bd.testEmptyAndFull();
		
		//extra add does not throw exception 
		bd.testAdd(bd.item5);
		bd.displayBag();
		
		System.out.println("Item removed: " + bd.testRemoveFirstItem());
		System.out.println("Item removed: " + bd.testRemoveFirstItem() + "\n");
		bd.displayBag();
	}

}
