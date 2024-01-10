
public class Sphere extends Shape {

	private double radius;
	
	public Sphere(double radius) {
		this.radius = radius;
	}

	@Override
	public double surface_area() {
		// SA = 4(pi)r^2
		return 4 * Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double volume() {
		// V = (4/3)(pi)r^3
		return 4.0 / 3 * Math.PI * Math.pow(radius, 3);
	}
	
	@Override
	public String toString() {
		//possible better implementation: put this toString in Shape.java because this is generic to all Shapes
		return String.format("%s\nsurface area: %.2f\nvolume: %.2f\n", this.getClass().getSimpleName(), surface_area(), volume());
	}

}
