package Lemming;

public class Marcheur extends LemmingState {

	protected Marcheur(Lemming lemming) {
		super(lemming);
	}

	@Override
	public State getState() {
		return State.MARCHEUR;
	}

	@Override
	public void move() {
		lemming.testLaveSortie();
		lemming.isChute(lemming);
		lemming.changeState();

		int x = lemming.getX();
		int y = lemming.getY();
		Grille grille = lemming.getGrid();
		
		if (grille.grid[x + 1][y] == Grille.EMPTY || grille.grid[x + 1][y] == Grille.LEMMING) {
			lemming.moveBottom();
			return;
		}
		if (!lemming.isLeft()) {
			if (grille.grid[x][y + 1] == Grille.EMPTY || grille.grid[x][y + 1] == Grille.LEMMING) {
				lemming.moveRight();
				return;
			}
			if ((grille.grid[x][y + 1] == Grille.DESTRUCTIBLE || grille.grid[x][y + 1] == Grille.INDESTRUCTIBLE || grille.grid[x][y + 1] == Grille.SPECIAL)
					&& grille.grid[x - 1][y + 1] == Grille.EMPTY && grille.grid[x - 1][y] == Grille.EMPTY) {
				lemming.moveTopRight();
				return;
			}
			lemming.setLeft(true);
		} else {
			if (grille.grid[x][y - 1] == Grille.EMPTY || grille.grid[x][y - 1] == Grille.LEMMING) {
				lemming.moveLeft();
				return;
			}
			if ((grille.grid[x][y - 1] == Grille.DESTRUCTIBLE || grille.grid[x][y - 1] == Grille.INDESTRUCTIBLE || grille.grid[x][y - 1] == Grille.SPECIAL)
					&& grille.grid[x - 1][y - 1] == Grille.EMPTY && grille.grid[x - 1][y] == Grille.EMPTY) {
				lemming.moveTopLeft();
				return;
			}
			lemming.setLeft(false);
		}
	}
}