package runtime;

import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

import map.Map;
import player.Player;
import rendering.Renderer;
import rendering.Window;

public class Runtime {
	
	boolean running = false;
	
	public Logger logger;
	private Window window = null;
	private Map map = null;
	private Player client_player;
	
	private static final int FPS = 100;
	
	/**
	 * Constructs all necessary objects
	 */
	public Runtime() {
		logger = Logger.getLogger(Runtime.class.getName());
		window = new Window("2D Game");
		client_player = new Player(0, 0);
		window.addMouseMotionListener(client_player);
		window.addKeyListener(client_player);
		window.addMouseListener(client_player);
		map = new Map("");
	}
	
	/**
	 * The getter for the flag that indicates whether or not a new game loop should be run
	 * before calling the quit() and clean_up() functions.
	 * @return a boolean.
	 */
	public boolean keep_running() {
		return this.running;
	}
	
	/**
	 * Should be called before the loop method is called.
	 */
	public void start() {
		this.logger.info("Starting game...");
		this.running = true;
	}
	
	/**
	 * Executes one iterations of the game loop.
	 */
	public void loop() {
		long start = System.currentTimeMillis();
		
		// Priming the map components to draw:
		client_player.update();
		Renderer.render_scene_middle_point(window, map, client_player);
		// Updating the graphics:
		window.repaint();
		
		// Setting the running variable to true if a window closing event has been detected.
		this.running = ! window.is_window_closing();
		
		int elapsed_render_time = (int) (System.currentTimeMillis() - start);
		int delay_time = 1000 / FPS - elapsed_render_time;
		if (delay_time > 0)
			try {
				Thread.sleep(delay_time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * Quits the game.
	 */
	public void quit() {
		this.logger.info("Quitting game...");
	}
	
	/**
	 * Cleans up any open resources.
	 */
	public void clean_up() {
		this.logger.info("Cleaning up resources...");
	}
	
	public static void main(String[] args) {
		
		Logger.getGlobal().setLevel(Level.INFO);
		
		Runtime game = new Runtime();
		game.start();
		
		game.logger.info("Game Initialized.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while (game.keep_running()) {
			game.loop();
		}
		
		game.quit();
		game.clean_up();
		
	}

}
