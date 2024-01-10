
public class Cylinder extends Shape {

	private double radius;
	private double height;
	
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	@Override
	public double surface_area() {
		// SA = 2(pi)(r)(h) + 2(pi)(r^2)
		return (2 * Math.PI * Math.pow(radius, 2)) + (2 * Math.PI * radius * height);
	}

	@Override
	public double volume() {
		// V = (pi)(r^2)(h)
		return Math.PI * Math.pow(radius, 2) * height;
	}
	
	@Override
	public String toString() {
		return String.format("%s\nsurface area: %.2f\nvolume: %.2f\n", this.getClass().getSimpleName(), surface_area(), volume());
	}

}
