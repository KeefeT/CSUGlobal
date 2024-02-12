
public class ShoppingCart implements Bag<ShoppingItem>{

	private final int default_capacity;
	private int numberOfProducts;
	private ShoppingItem[] myBag;
	
	public ShoppingCart() {
		this.default_capacity = 10;
		this.numberOfProducts = 0;
		this.myBag = new ShoppingItem[default_capacity];
	}
	
	public ShoppingCart(int maxSize) {
		this.numberOfProducts = 0;
		if (maxSize > 0) {
			this.default_capacity = maxSize;
		} else {
			this.default_capacity = 10;	
		}
		this.myBag = new ShoppingItem[default_capacity];
	}
	
	@Override
	public ShoppingItem[] toArray() {
		return this.myBag;
	}
	
	@Override
	public boolean add(ShoppingItem item) {
		if (!isFull()) {
			for (int i = 0; i < this.myBag.length; i++) {
				if (this.myBag[i] == null) {
					this.myBag[i] = item;
					numberOfProducts++;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isFull() {
		return this.numberOfProducts < this.default_capacity ? false : true;
	}

	@Override
	public int getCurrentSize() {
		return this.numberOfProducts;
	}

	@Override
	public boolean isEmpty() {
		return this.numberOfProducts == 0;
	}

	@Override
	public ShoppingItem remove() {
		if (this.isEmpty()) {
			return null;
		}
		
		ShoppingItem itemToRemove = null;
		
		for (int i = 0; i < this.myBag.length; i++) {
			if (this.myBag[i] != null) {
				itemToRemove = this.myBag[i];
				this.myBag[i] = null;
				numberOfProducts--;
				break;
			}
		}
		
		return itemToRemove;
	}

	@Override
	public boolean remove(ShoppingItem anEntry) {
		if (this.isEmpty()) {
			return false;
		}
	
		for (int i = 0; i < this.myBag.length; i++) {
			if (this.myBag[i] != null && this.myBag[i].equals(anEntry)) {
				this.myBag[i] = null;
				numberOfProducts--;
				return true;
			}
		}
		
		return false;
	}

	@Override
	public int getFrequencyOf(ShoppingItem anEntry) {
		int count = 0;
		
		for (int i = 0; i < this.myBag.length; i++) {
			if (this.myBag[i] != null && this.myBag[i].equals(anEntry)) {
				count++;
			}
		}
		
		return count;
	}

	@Override
	public boolean contains(ShoppingItem anEntry) {
		for (int i = 0; i < this.myBag.length; i++) {
			if (this.myBag[i] != null && this.myBag[i].equals(anEntry)) {
				return true;
			}
		}
		
		return false;
	}

}
