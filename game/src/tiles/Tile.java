package tiles;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Tile {
	
	protected static BufferedImage tile_texture;
	
	public static final int TILE_SIZE = 50;
	private static ArrayList<String> tile_classes = new ArrayList<String>();

	public Tile() {
		if (! tile_classes.contains(this.getClass().getName())) {
			tile_classes.add(this.getClass().getName());
			initialize();
		}
	}
	
	protected static void initialize() {
		tile_texture = new BufferedImage(Tile.TILE_SIZE, Tile.TILE_SIZE, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < tile_texture.getWidth(); i++)
			for (int n = 0; n < tile_texture.getHeight(); n++)
				if (i == 0 || n == 0 || i == Tile.TILE_SIZE - 1 || n == Tile.TILE_SIZE - 1)
					tile_texture.setRGB(i, n, 0);
				else
					tile_texture.setRGB(i, n, 0xFFFFFFFF);
	}
	
	public BufferedImage get_image() {
		return tile_texture;
	}
	
}
