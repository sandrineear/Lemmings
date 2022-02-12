package Lemming;

public abstract class LemmingState {
	public enum State {
		BLOQUEUR, BOMBEUR, CHARPENTIER, FOREUR, GRIMPEUR, MARCHEUR, PARACHUTISTE, TUNNELIER
	}

	protected Lemming lemming;
	private Direction direction;

	protected LemmingState(Lemming lemming) {
		this.lemming = lemming;
		this.direction = Direction.Right;
	}
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public abstract State getState();

	public abstract void move();
}
