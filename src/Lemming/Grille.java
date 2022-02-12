package Lemming;

public class Grille {
	public int grid[][] = { { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 },
			{ 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 1, 6, 0, 0, 7 },
			{ 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 7 },
			{ 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 4, 7 },
			{ 7, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 7 },
			{ 7, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 7 },
			{ 7, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 7 },
			{ 7, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 7 },
			{ 7, 0, 0, 0, 0, 0, 0, 0, 0, 1, 8, 1, 1, 0, 0, 0, 0, 0, 0, 7 },
			{ 7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 7 },
			{ 7, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1, 1, 1, 0, 3, 0, 0, 0, 0, 7 },
			{ 7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 7 },
			{ 7, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7 },
			{ 7, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 7 },
			{ 7, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 1, 1, 9, 9, 9, 9, 1, 7 },
			{ 7, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 7 },
			{ 7, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 6, 0, 0, 7 },
			{ 7, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7 },
			{ 7, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 7 },
			{ 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 } };

	public static final int EMPTY = 0;
	public static final int DESTRUCTIBLE = 1;
	public static final int LAVE = 2; 
	public static final int ENTREE = 3;
	public static final int SORTIE = 4;
	public static final int LEMMING = 5;
	public static final int TELEPORT = 6;
	public static final int BORD = 7;
	public static final int SPECIAL = 8;
	public static final int INDESTRUCTIBLE = 9;
	public static final int LEMMINGDESTRUCTIBLE = 10;
	private int x, y;

	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int x, int y, int val) {
		grid[x][y] = val;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
