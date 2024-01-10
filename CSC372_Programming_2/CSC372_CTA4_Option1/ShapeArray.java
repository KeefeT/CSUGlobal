
public class ShapeArray {

	private Shape[] shapeArray;
	
	public ShapeArray() {
		shapeArray = new Shape[3];
		shapeArray[0] = new Sphere(5);
		shapeArray[1] = new Cylinder(5, 10);
		shapeArray[2] = new Cone(3, 5);		
	}
	
	public static void main(String[] args) {
		ShapeArray obj = new ShapeArray();
		
		for (Shape item : obj.shapeArray) {
			System.out.println(item);
		}
	}
}
