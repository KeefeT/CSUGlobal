import java.util.Comparator;

public class CompareCarsMPG implements Comparator<Car> {

	@Override
	public int compare(Car o1, Car o2) {
		//prints in ascending order
		//ie
		//1
		//2
		//3
		//etc
		if (o1.getMpg() < o2.getMpg()) {
			return -1;
		} else if (o1.getMpg() == o2.getMpg()) {
			return 0;
		} else {
			return 1;
		}
				
	}

}
