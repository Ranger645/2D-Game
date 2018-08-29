package rendering;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	private ArrayList<BufferedImage> image_buffer = new ArrayList<BufferedImage>();
	private ArrayList<Point> image_points = new ArrayList<Point>();
	
	public Canvas(String game_name) {
		super();
		this.setDoubleBuffered(true);
	}
	
	public void add_image(BufferedImage image, int x, int y) {
		image_buffer.add(image);
		image_points.add(new Point(x, y));
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		for (int i = 0; i < image_buffer.size(); i++) {
			g2.drawImage(image_buffer.get(i), 
					(int) image_points.get(i).getX(), 
					(int) image_points.get(i).getY(), 
					null);
		}
		image_buffer.clear();
		image_points.clear();
	}
	
}
