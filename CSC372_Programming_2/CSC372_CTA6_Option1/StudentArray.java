
import java.util.ArrayList;

public class StudentArray {

	ArrayList<Student> studentList;
	
	public StudentArray() {
		studentList = new ArrayList<Student>(10);
		studentList.add(new Student(0, "Bob", "123 Street Street"));
		studentList.add(new Student(1, "Bill", "123 Street Ave"));
		studentList.add(new Student(9, "Eva", "123 Street Falls"));
		studentList.add(new Student(2, "Alice", "123 Street Boulevard"));
		studentList.add(new Student(7, "David", "123 Street Bluff"));
		studentList.add(new Student(3, "Betty", "123 Street Circle"));
		studentList.add(new Student(5, "Charles", "123 Street Park"));
		studentList.add(new Student(4, "Carol", "123 Street Wharf"));
		studentList.add(new Student(6, "Diana", "123 Street Alley"));
		studentList.add(new Student(8, "Edward", "123 Street Canyon"));
	}

	public static void main(String[] args) {
		StudentArray SA = new StudentArray();
		SelectionSort Sort = new SelectionSort();
		
		Sort.selectionSort(SA.studentList, new CompareStudentName());
		
		System.out.println("Printing student list sorted by name");
		for (Student student : SA.studentList) {
			System.out.println(student);
		}
		
		System.out.print("\n");
		
		Sort.selectionSort(SA.studentList, new CompareStudentRollno());
		
		System.out.println("Printing student list sorted by rollno");
		for (Student student : SA.studentList) {
			System.out.println(student);
		}
		
	}

}
