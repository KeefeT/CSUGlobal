
public class CSC320_CTA1_Option1 {

	private static class Person {
		
		String first;
		String last;
		String address;
		String city;
		String zip;
		
		public Person() {
			
			this.first = "Walter";
			this.last = "White";
			this.address = "308 Negra Arroyo Lane";
			this.city = "Albuquerque";
			this.zip = "87104";
			
		}
		
		public Person(String first, String last, String address, String city, String zip) {
			this.first = first;
			this.last = last;
			this.address = address;
			this.city = city;
			this.zip = zip;
		}
		
		public String toString() {
			String out = "";
			out += first + "\n";
			out += last + "\n";
			out += address + "\n";
			out += city + "\n";
			out += zip + "\n";
			return out;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person generic = new Person();
		Person custom = new Person("Thomas", "Keefe", "101 Street Street", "Denver", "123456");
		
		System.out.println("printing default constructor:\n" + generic);
		System.out.println("printing custom constructor:\n" + custom);
		
	}

}
