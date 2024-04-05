
import java.util.LinkedList;
import java.util.Queue;

public class Order {

	Queue<OrderData> queue;
	
	public Order() {
		this.queue = new LinkedList<OrderData>();
	}
	
	public boolean addOrder(OrderData order) {
		return this.queue.offer(order);
	}
	
	public OrderData takeNextOrder() {
		return this.queue.poll();
	}
	
	@Override
	public String toString() {
		return queue.toString();	
	}

}
