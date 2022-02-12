package Lemming;

public class Parachutiste extends LemmingState {

	protected Parachutiste(Lemming lemming) {
		super(lemming);
	}

	@Override
	public State getState() {
		return State.PARACHUTISTE;
	}

	@Override
	public void move() {
		lemming.testLaveSortie();
		int x = lemming.getX();
		int y = lemming.getY();
		Grille grille = lemming.getGrid();
		
		if (lemming.getClique() == 1) {
			lemming.setTempsEcoule(lemming.getTempsEcoule() + 1);
			lemming.setEstMort(false);
			while (grille.grid[x + 1][y] == Grille.EMPTY && lemming.getTempsEcoule() % 2 == 0) {
				lemming.moveBottom();
			}
			if(grille.grid[x + 1][y] == Grille.DESTRUCTIBLE || grille.grid[x + 1][y] == Grille.INDESTRUCTIBLE 
					|| grille.grid[x + 1][y] == Grille.LAVE || grille.grid[x + 1][y] == Grille.SORTIE || grille.grid[x + 1][y] == Grille.TELEPORT)
				lemming.setState(new Marcheur(lemming));
		} else {
			lemming.setState(new Marcheur(lemming));
		}
		GameView.parachuter = false;
	}
}