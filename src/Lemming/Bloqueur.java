package Lemming;

public class Bloqueur extends LemmingState {

	protected Bloqueur(Lemming lemming) {
		super(lemming);
	}

	@Override
	public State getState() {
		return State.BLOQUEUR;
	}

	@Override
	public void move() {
		if (lemming.getClique() == 1) {
			lemming.setX(lemming.getX());
			lemming.setY(lemming.getY());
			if (GameView.marcher == true && lemming.getClique() == 1) {
				lemming.setState(new Marcheur(lemming));
			} else if (GameView.marcher == true){
				lemming.setState(new Marcheur(lemming));
			}
		} else {
			lemming.setState(new Marcheur(lemming));
		}
		GameView.bloquer = false;
	}
}