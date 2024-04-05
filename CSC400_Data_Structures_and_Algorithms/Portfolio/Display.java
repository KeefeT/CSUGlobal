
import java.util.ArrayList;

public class Display {
	
	private ArrayList<OrderData> ordersByName;
	private ArrayList<OrderData> ordersByNumber;
	
	public Display() {
		this.ordersByName = new ArrayList<OrderData>();
		this.ordersByNumber = new ArrayList<OrderData>();
	}
	
	public int pivotByNames(ArrayList<OrderData> array, int low, int high) {
		OrderData pivot = array.get(high);
		int i = low - 1;
		
		for (int k = low; k < high; k++) {
			
			if (array.get(k).compareNames(pivot) <= 0) {
				i++;
			
				OrderData temp = array.get(i);
				array.set(i, array.get(k));
				array.set(k, temp);
			}
		}
		
		OrderData temp = array.get(i+1);
		array.set(i+1, array.get(high));
		array.set(high, temp);
		
		return i+1;
	}
	
	public int pivotByNumbers(ArrayList<OrderData> array, int low, int high) {	
		OrderData pivot = array.get(high);
		int i = low - 1;
		
		for (int k = low; k < high; k++) {
			
			if (array.get(k).compareNumbers(pivot) <= 0) {
				i++;
			
				OrderData temp = array.get(i);
				array.set(i, array.get(k));
				array.set(k, temp);
			}
		}
		
		OrderData temp = array.get(i+1);
		array.set(i+1, array.get(high));
		array.set(high, temp);
		
		return i+1;
	}
	
	public void quicksortNames(int low, int high) {
		if (low < high) {
			int indexNames = pivotByNames(this.ordersByName, 0, high);
			
			quicksortNames(low, indexNames - 1); 
			quicksortNames(indexNames + 1, high); 
		}
	}
	
	public void quicksortNumbers(int low, int high) {
		if (low < high) {
			int indexNumbers = pivotByNumbers(this.ordersByNumber, 0, high);
			
			quicksortNumbers(low, indexNumbers - 1); 
			quicksortNumbers(indexNumbers + 1, high); 
		}
	}

	public void addToOrdersByName(OrderData order) {
		this.ordersByName.add(order);
		quicksortNames(0, this.ordersByName.size() - 1);
	}
	
	public void addToOrdersByNumber(OrderData order) {
		this.ordersByNumber.add(order);
		quicksortNumbers(0, this.ordersByNumber.size() - 1);
	}
	
	public boolean removeFromOrdersByName(OrderData order) {
		return this.ordersByName.remove(order);
	}
	
	public boolean removeFromOrdersByNumber(OrderData order) {
		return this.ordersByNumber.remove(order);
	}
	
	@Override
	public String toString() {
		
		String out = "\n";
		
		out += "Contents of ordersByName: \n";
		
		for (int i = 0; i < this.ordersByName.size(); i++) {
			out += i + ": " + this.ordersByName.get(i).toString();
			out += "\n";
		}
		
		out += "\n";
				
		out += "Contents of ordersByNumber: \n";
		
		for (int i = 0; i < this.ordersByNumber.size(); i++) {
			out += i + ": " + this.ordersByNumber.get(i).toString();
			out += "\n";
		}
				
		return out;
	}
}
