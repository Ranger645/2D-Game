package map;

import java.awt.Point;

import tiles.Tile;

public class Map {
	
	private Tile[][] tiles;

	public Map(String map_path) {
		int width = 100;
		int height = 100;
		tiles = new Tile[width][height];
		for (int i = 0; i < width; i++)
			for (int n = 0; n < height; n++)
				tiles[i][n] = new Tile();
	}
	
	public int getWidth() {
		return tiles.length;
	}
	
	public int getHeight() {
		return tiles[0].length;
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= this.getWidth() || y >= this.getHeight())
			return null;
		return tiles[x][y];
	}
	
	public Tile getTile(Point p) {
		return tiles[(int) p.getX()][(int) p.getY()];
	}
	
}
