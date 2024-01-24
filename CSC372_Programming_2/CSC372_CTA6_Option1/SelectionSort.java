
import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSort {

	public void selectionSort(ArrayList<Student> list, Comparator<Student> comparator) {
		
		int min;
		Student temp;
		
		for (int i = 0; i < list.size(); i++) {
			min = i;
			
			for (int j = i+1; j < list.size(); j++) {			
				if (comparator.compare(list.get(j), list.get(min)) < 0) {
					min = j;
				}
			}
			
			temp = list.get(i);
			list.set(i, list.get(min));
			list.set(min, temp);
		}
		
	}
}
