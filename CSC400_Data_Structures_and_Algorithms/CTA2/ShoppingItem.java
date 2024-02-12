
public class ShoppingItem {

	private int customerNumber;
	private int sku;
	private String itemName;
	private double price;
	
	public ShoppingItem(int customerNumber, int sku, String itemName, double price) {
		this.customerNumber = customerNumber;
		this.sku = sku;
		this.itemName = itemName;
		this.price = price;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public double getPrice() {
		return price;
	}
	
	public int getSku() {
		return sku;
	}

	public boolean equals(ShoppingItem i) {
		return (this.customerNumber == i.customerNumber) && (this.sku == i.sku) && (this.itemName.equals(i.itemName)) && (this.price == i.price);
	}
	
	public String toString() {
		return String.format("customer id: %d, sku: %d, item name: %s, price: %.2f", getCustomerNumber(), getSku(), getItemName(), getPrice());
	}

}
