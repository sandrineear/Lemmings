package Lemming;

public class Bombeur extends LemmingState {

	protected Bombeur(Lemming lemming) {
		super(lemming);
	}

	@Override
	public State getState() {
		return State.BOMBEUR;
	}

	@Override
	public void move() {
		int x = lemming.getX();
		int y = lemming.getY();
		Grille grille = lemming.getGrid();

		if (lemming.getClique() == 1) {
			if (grille.grid[x + 1][y] == Grille.DESTRUCTIBLE || grille.grid[x + 1][y] == Grille.INDESTRUCTIBLE) {
				lemming.remettreEmpty();
				for (int i = -2; i <= 2; i++) {
					int j = -2;
					while (j <= 2) {
						if (grille.grid[x + i][y + j] == Grille.DESTRUCTIBLE) {
							grille.grid[x + i][y + j] = Grille.EMPTY;
						} else if (grille.grid[x + i][y + j] == Grille.SPECIAL) {
							grille.grid[x + i][y + j] = Grille.EMPTY;
							lemming.moveSpecial();
						} else if (grille.grid[x + i][y + j] == Grille.LEMMINGDESTRUCTIBLE) {
							lemming.remettreEmpty();
							lemming.moveExplosion();
						}
						j++;
					}
				}
				lemming.setEstMort(true);
			}
		}
		lemming.setState(new Marcheur(lemming));
		GameView.exploser = false;
	}
}
