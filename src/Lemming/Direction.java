package Lemming;

public enum Direction {
	Up(0, -1), Down(0, 1), Left(-1, 0), Right(1, 0);

	private int x;
	private int y;

	Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}
