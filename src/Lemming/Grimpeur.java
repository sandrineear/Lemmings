package Lemming;

public class Grimpeur extends LemmingState {

	protected Grimpeur(Lemming lemming) {
		super(lemming);
	}

	@Override
	public State getState() {
		return State.GRIMPEUR;
	}

	@Override
	public void move() {
		lemming.testLaveSortie();
		int x = lemming.getX();
		int y = lemming.getY();
		Grille grille = lemming.getGrid();

		if (grille.grid[x][y + 1] != Grille.EMPTY) {
			lemming.setLeft(false);
		} else if (grille.grid[x][y - 1] != Grille.EMPTY) {
			lemming.setLeft(true);
		}

		if (lemming.getClique() == 1) {
			while (grille.grid[x - 1][y] == Grille.EMPTY && (grille.grid[x][y + 1] == Grille.DESTRUCTIBLE || grille.grid[x][y + 1] == Grille.INDESTRUCTIBLE || grille.grid[x][y + 1] == Grille.LEMMINGDESTRUCTIBLE)
					|| grille.grid[x - 1][y] == Grille.EMPTY && (grille.grid[x][y - 1] == Grille.DESTRUCTIBLE || grille.grid[x][y - 1] == Grille.INDESTRUCTIBLE || grille.grid[x][y - 1] == Grille.LEMMINGDESTRUCTIBLE)) {
				lemming.moveTop();
			}
			if (!lemming.isLeft()) {
				grimpeurRight(grille, x, y);
			} else {
				grimpeurLeft(grille, x, y);
			}
		} else {
			lemming.setState(new Marcheur(lemming));
		}
		GameView.grimper = false;
	}
	
	public void grimpeurRight(Grille grille, int x, int y) {
		if (grille.grid[x][y + 1] == Grille.EMPTY && grille.grid[x - 1][y] == Grille.EMPTY) {
			lemming.moveRight();
			lemming.setState(new Marcheur(lemming));
		}
		lemming.setLeft(false);
	}
	
	public void grimpeurLeft(Grille grille, int x, int y) {
		if (grille.grid[x][y - 1] == Grille.EMPTY && grille.grid[x - 1][y] == Grille.EMPTY) {
			lemming.moveLeft();
			lemming.setState(new Marcheur(lemming));
		}
		lemming.setLeft(true);
	}
}
