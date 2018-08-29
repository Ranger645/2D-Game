package rendering;

import map.Map;
import tiles.Tile;

public class Renderer {

	public static void render_scene_top_right_point(Window window, Map map, int x_pos, int y_pos) {
		int tile_offset_x = (int) (x_pos / (Tile.TILE_SIZE * 1.0));
		int tile_offset_y = (int) (y_pos / (Tile.TILE_SIZE * 1.0));
		int pixel_backtrace_x = x_pos - tile_offset_x * Tile.TILE_SIZE;
		int pixel_backtrace_y = y_pos - tile_offset_y * Tile.TILE_SIZE;
		for (int x = 0; x < window.getWidth() / Tile.TILE_SIZE + 2; x++)
			for (int y = 0; y < window.getHeight() / Tile.TILE_SIZE + 1; y++) {
				Tile tile = map.getTile(x + tile_offset_x, y + tile_offset_y);
				if (tile != null)
					window.add_image(tile.get_image(), x * Tile.TILE_SIZE - pixel_backtrace_x,
							y * Tile.TILE_SIZE - pixel_backtrace_y);
			}
	}

	public static void render_scene_middle_point(Window window, Map map, int x_pos, int y_pos) {
		x_pos -= window.getWidth() / 2;
		y_pos -= window.getHeight() / 2;
		int tile_offset_x = (int) (x_pos / (Tile.TILE_SIZE * 1.0));
		int tile_offset_y = (int) (y_pos / (Tile.TILE_SIZE * 1.0));
		int pixel_backtrace_x = x_pos - tile_offset_x * Tile.TILE_SIZE;
		int pixel_backtrace_y = y_pos - tile_offset_y * Tile.TILE_SIZE;
		for (int x = 0; x < window.getWidth() / Tile.TILE_SIZE + 2; x++)
			for (int y = 0; y < window.getHeight() / Tile.TILE_SIZE + 1; y++) {
				Tile tile = map.getTile(x + tile_offset_x, y + tile_offset_y);
				if (tile != null)
					window.add_image(tile.get_image(), x * Tile.TILE_SIZE - pixel_backtrace_x,
							y * Tile.TILE_SIZE - pixel_backtrace_y);
			}
	}

}
