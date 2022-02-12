package Lemming;

public class Foreur extends LemmingState {

	private static final int pasMax = 5;
	private int pasMin;

	protected Foreur(Lemming lemming) {
		super(lemming);
		this.pasMin = 0;
	}

	@Override
	public State getState() {
		return State.FOREUR;
	}

	@Override
	public void move() {
		lemming.testLaveSortie();
		int x = lemming.getX();
		int y = lemming.getY();
		Grille grille = lemming.getGrid();

		if (lemming.getClique() == 1) {
			while (pasMin < pasMax && grille.grid[x + 1][y] == Grille.DESTRUCTIBLE || grille.grid[x + 1][y] == Grille.SPECIAL || grille.grid[x + 1][y] == Grille.LEMMINGDESTRUCTIBLE) {
				if (grille.grid[x + 1][y] == Grille.SPECIAL) {
					lemming.moveSpecial();
				}
				if (grille.grid[x + 1][y] == Grille.LEMMINGDESTRUCTIBLE) {
					lemming.remettreEmpty();
					lemming.moveExplosion();
				}
				lemming.moveBottom();
				pasMin++;
				return;
			}
			lemming.setState(new Marcheur(lemming));
		} else {
			lemming.setState(new Marcheur(lemming));
		}
		GameView.forer = false;
	}
}
