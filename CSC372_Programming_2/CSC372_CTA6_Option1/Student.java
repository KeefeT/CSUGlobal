
public class Student {

	int rollno;
	String name;
	String address;
	
	Student(int rollno, String name, String address)
	{  
		this.rollno = rollno;  
		this.name = name;  
		this.address = address;  
	}  
	
	public String toString() {
		return String.format("%d, %s, %s", this.rollno, this.name, this.address);
	}

}
