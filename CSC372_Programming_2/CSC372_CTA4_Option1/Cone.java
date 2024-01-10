
public class Cone extends Shape {

	private double radius;
	private double height;
	
	public Cone(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	@Override
	public double surface_area() {
		// SA = (pi)(r)(r + sqrt((h^2) + (r^2)))
		return Math.PI * radius * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));
	}

	@Override
	public double volume() {
		// V = (pi)(r^3)(h/3)
		return Math.PI * Math.pow(radius, 2) * height / 3.0;
	}
	
	@Override
	public String toString() {
		return String.format("%s\nsurface area: %.2f\nvolume: %.2f\n", this.getClass().getSimpleName(), surface_area(), volume());
	}
	
}
