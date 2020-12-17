public class Vector {

	double x, y, mag, angle;
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
		mag = Math.sqrt(x * x + y * y);
		angle = Math.atan2(y, x);
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
	
	public double angle(Vector v) { //angle from 0 to pi
		double bet = Math.max(angle, v.angle) - Math.min(angle, v.angle);
		return Math.min(bet, 2 * Math.PI - bet);
	}
	
}
