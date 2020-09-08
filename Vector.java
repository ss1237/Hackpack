public class Vector {

	double x, y, mag;
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
		mag = Math.sqrt(x * x + y * y);
	}
	
	public Vector add(Vector v) {
		return new Vector(x + v.x, y + v.y);
	}
	
	public Vector subtract(Vector v) {
		return new Vector(x + v.x, y + v.y);
	}
	
	public double dot(Vector v) {
		return x * v.x + y * v.y;
	}
	
	public double cross(Vector v) {
		return x * v.y - y * v.x;
	}
	
	public double angle(Vector v) {
		return Math.atan2(cross(v), dot(v));
	}
	
}
