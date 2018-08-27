package runtime;

public class Runtime {
	
	boolean running = false;
	
	public Runtime() {
		
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
		this.running = true;
	}
	
	/**
	 * Executes one iterations of the game loop.
	 */
	public void loop() {
		
	}
	
	/**
	 * Quits the game.
	 */
	public void quit() {
		
	}
	
	/**
	 * Cleans up any open resources.
	 */
	public void clean_up() {
		
	}
	
	public static void main(String[] args) {
		
		Runtime game = new Runtime();
		game.start();
		
		while (game.keep_running()) {
			game.loop();
		}
		
		game.quit();
		game.clean_up();
		
	}

}
