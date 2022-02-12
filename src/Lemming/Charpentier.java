package Lemming;

public class Charpentier extends LemmingState {
	private static final int pasMax = 5;
	private int pasMin;

	protected Charpentier(Lemming lemming) {
		super(lemming);
		this.pasMin = 0;
	}

	@Override
	public State getState() {
		return State.CHARPENTIER;
	}

	@Override
	public void move() {
		lemming.testLaveSortie();
		int x = lemming.getX();
		int y = lemming.getY();
		Grille grille = lemming.getGrid();

		if (lemming.getClique() == 1) {
			if (!lemming.isLeft()) {
				while (pasMin < pasMax && grille.grid[x - 1][y + 1] == Grille.EMPTY) {
					grille.grid[x][y + 1] = Grille.DESTRUCTIBLE;
					lemming.moveTopRight();
					pasMin++;
					lemming.setLeft(false);
					return;
				}
			} else {
				while (pasMin < pasMax && grille.grid[x - 1][y - 1] == Grille.EMPTY) {
					grille.grid[x][y - 1] = Grille.DESTRUCTIBLE;
					lemming.moveTopLeft();
					pasMin++;
					lemming.setLeft(true);
					return;
				}
			}
			lemming.setState(new Marcheur(lemming));
		} else {
			lemming.setState(new Marcheur(lemming));
		}
		GameView.construire = false;
	}
}
