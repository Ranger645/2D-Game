package rendering;

import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Window extends JFrame {
	
	private Canvas canvas;
	private boolean window_closing = false;
	
	public Window(String game_name) {
		super();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(game_name);
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        window_closing = true;
		    }
		});
		
		canvas = new Canvas(game_name);
		this.add(canvas);
		
		this.setVisible(true);
	}
	
	public boolean is_window_closing() {
		return window_closing;
	}
	
	public void add_image(BufferedImage image, int x, int y) {
		this.canvas.add_image(image, x, y);
	}
	
}
