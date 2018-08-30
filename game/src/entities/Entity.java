package entities;

public class Entity {
	
	protected double x = 0, y = 0;
	protected double angle = 0; // The angle off of the vertical.
	protected double x_velocity = 1.0, y_velocity = 1.0;
	
	public Entity() {
		
	}
	
	public Entity(int x, int y) {
		this();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

}
