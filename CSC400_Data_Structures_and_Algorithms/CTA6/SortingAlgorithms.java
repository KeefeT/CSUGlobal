
public class SortingAlgorithms {
	
	public static boolean testArrayAscending(int[] arr) {
		
		if (arr.length == 0 || arr == null) {
			return false;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				return true;
			} else if (arr[i] < arr[i+1]) {
				continue;
			} else {
				return false;
			}
		}
		return false;
	}
	
}
