package player;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import entities.Entity;
import rendering.Window;
import tiles.Tile;

public class Player extends Entity implements MouseMotionListener, MouseListener, KeyListener {

	private boolean moving_up = false, moving_down = false, moving_right = false, moving_left = false;
	private BufferedImage player_image = null;
	private double acceleration = 1, max_velocity = 8, friction = 0.5;

	public Player(int x, int y) {
		super(x, y);
		this.initialize_texture();
	}

	public Point update() {
		// Increasing velocities based on user inputs
		if (moving_up) {
			this.y_velocity -= this.acceleration;
		}

		if (moving_down) {
			this.y_velocity += this.acceleration;
		}

		if (moving_right) {
			this.x_velocity += this.acceleration;
		}

		if (moving_left) {
			this.x_velocity -= this.acceleration;
		}

		// Capping out x velocity
		if (this.x_velocity > this.max_velocity)
			this.x_velocity = this.max_velocity;
		else if (this.x_velocity < -this.max_velocity)
			this.x_velocity = -this.max_velocity;

		// Capping out y velocity
		if (this.y_velocity > this.max_velocity)
			this.y_velocity = this.max_velocity;
		else if (this.y_velocity < -this.max_velocity)
			this.y_velocity = -this.max_velocity;

		// Applying Friction to accelerate opposite the direction of motion.
		if (!moving_up && this.y_velocity < 0) {
			this.y_velocity += this.friction;
			if (!this.moving_down && this.y_velocity > 0)
				this.y_velocity = 0;
		}

		if (!moving_down && this.y_velocity > 0) {
			this.y_velocity -= this.friction;
			if (!this.moving_up && this.y_velocity < 0)
				this.y_velocity = 0;
		}

		if (!moving_right && this.x_velocity > 0) {
			this.x_velocity -= this.friction;
			if (!this.moving_left && this.x_velocity < 0)
				this.x_velocity = 0;
		}

		if (!moving_left && this.x_velocity < 0) {
			this.x_velocity += this.friction;
			if (!this.moving_right && this.x_velocity > 0)
				this.x_velocity = 0;
		}

		// Adding velocities to positions
		this.x += this.x_velocity;
		this.y += this.y_velocity;

		return new Point((int) x, (int) y);
	}

	public void initialize_texture() {
		player_image = new BufferedImage(Tile.TILE_SIZE * 2, Tile.TILE_SIZE * 2, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = player_image.createGraphics();

		// making background transparent.
		for (int i = 0; i < player_image.getWidth(); i++) {
			for (int n = 0; n < player_image.getHeight(); n++) {
				player_image.setRGB(i, n, 0x00000000);
			}
		}
		g.setPaint(Color.BLUE);
		g.fillOval(0, 0, Tile.TILE_SIZE * 2, Tile.TILE_SIZE * 2);
		g.setPaint(Color.ORANGE);
		g.setStroke(new BasicStroke(3));
		g.drawOval(0, 0, Tile.TILE_SIZE * 2, Tile.TILE_SIZE * 2);
		g.fillOval(0, 0, 30, 30);
		g.fillOval(70, 0, 30, 30);
	}

	public BufferedImage get_player_image() {
		((Graphics2D) this.player_image.getGraphics()).rotate(this.angle);
		return this.player_image;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.set_movement(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.set_movement(e.getKeyCode(), false);
	}

	private void set_movement(int key_code, boolean state) {
		if (key_code == KeyEvent.VK_W) {
			moving_up = state;
		} else if (key_code == KeyEvent.VK_S) {
			moving_down = state;
		} else if (key_code == KeyEvent.VK_D) {
			moving_right = state;
		} else if (key_code == KeyEvent.VK_A) {
			moving_left = state;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		double x_difference = (e.getX() - Window.WINDOW_WIDTH / 2);
		double y_difference = (Window.WINDOW_HEIGHT / 2 - e.getY());
		if (x_difference == 0) {
			if (y_difference > 0)
				this.angle = 0;
			else
				this.angle = 180;
		} else {
			this.angle = Math.toDegrees(Math.atan(y_difference / x_difference));
			if (x_difference >= 0 && y_difference >= 0)
				this.angle = 90 - this.angle;
			else if (x_difference >= 0)
				this.angle = 90 - this.angle;
			else if (y_difference <= 0)
				this.angle = 270 - this.angle;
			else
				this.angle = 270 - this.angle;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public double get_angle() {
		return this.angle;
	}

}
