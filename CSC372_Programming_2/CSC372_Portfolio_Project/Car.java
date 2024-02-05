
public class Car {

	private String make;
	private String model;
	private double mpg;
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getMpg() {
		return mpg;
	}

	public void setMpg(double mpg) {
		this.mpg = mpg;
	}

	public Car(String make, String model, double mpg) {
		this.make = make;
		this.model = model;
		this.mpg = mpg;
	}
	
	public String toString() {
		return String.format("%s %s, %.2f mpg\n", make, model, mpg);
	}

}
