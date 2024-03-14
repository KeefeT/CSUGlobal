
public class TestClass {

	public static void main(String[] args) {
		
		int[] arr1 = {0,1,2,3,4,5,6,7,8,9};
		int[] arr2 = {0,1,2,3,4,6,5,7,8,9};
		
		System.out.println("is arr1 sorted? : " + SortingAlgorithms.testArrayAscending(arr1));
		System.out.println("is arr2 sorted? : " + SortingAlgorithms.testArrayAscending(arr2));

	}

}
