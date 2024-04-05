
public class OrderData {

	private final String lastName;
	private final int orderNumber;
	private final double orderCost;

	public OrderData(String lastName, int orderNumber, double orderCost) {
		this.lastName = lastName;
		this.orderNumber = orderNumber;
		this.orderCost = orderCost;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	
	public double getOrderCost() {
		return orderCost;
	}
	
	public int compareNames(OrderData o1) {
		return this.lastName.compareTo(o1.lastName);
	}
	
	public int compareNumbers(OrderData o1) {
		return this.orderNumber - o1.orderNumber;
	}

	@Override
	public String toString() {
		return "OrderData [lastName=" + lastName + ", orderNumber=" + orderNumber + ", orderCost=" + orderCost + "]";
	}
}
