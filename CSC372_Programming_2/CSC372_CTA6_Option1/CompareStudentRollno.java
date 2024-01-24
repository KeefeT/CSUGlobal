
import java.util.Comparator;  

public class CompareStudentRollno implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		Student s1 = (Student) o1;  
		Student s2 = (Student) o2;  
		int ret;

		if (s1.rollno < s2.rollno) {
			ret = -1;
		} else if (s1.rollno == s2.rollno) {
			ret = 0;
		} else {
			ret = 1;
		}
		
		return ret;
	}

}
