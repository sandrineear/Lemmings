package Lemming;

public class Tunnelier extends LemmingState {

	protected Tunnelier(Lemming lemming) {
		super(lemming);
	}

	@Override
	public State getState() {
		return State.TUNNELIER;
	}

	@Override
	public void move() {
		lemming.testLaveSortie();
        int x = lemming.getX();
        int y = lemming.getY();
        Grille grille = lemming.getGrid();

        if (lemming.getClique() == 1) {
            if (!lemming.isLeft()) {
            	tunnelierRight(grille, x, y);
            } else {
                tunnelierLeft(grille, x, y);
            }
        } else {
            lemming.setState(new Marcheur(lemming));
        }
        GameView.creuser = false;
	}
	
	public void tunnelierRight(Grille grille, int x, int y) {
		while (grille.grid[x][y + 1] == Grille.DESTRUCTIBLE || grille.grid[x][y + 1] == Grille.SPECIAL || grille.grid[x][y + 1] == Grille.LEMMINGDESTRUCTIBLE) {
            if (grille.grid[x][y + 1] == Grille.INDESTRUCTIBLE)
                return;
            if (grille.grid[x][y + 1] == Grille.SPECIAL) 
                lemming.moveSpecial();
            if (grille.grid[x][y + 1] == Grille.LEMMINGDESTRUCTIBLE) {
				lemming.remettreEmpty();
				lemming.moveExplosion();
            }
            lemming.moveRight();
        }
        if (grille.grid[x][y + 1] == Grille.EMPTY || grille.grid[x + 1][y + 1] == Grille.EMPTY) {
        	lemming.moveRight();
            lemming.setState(new Marcheur(lemming));
        }
        lemming.setLeft(false);
	}
	
	public void tunnelierLeft(Grille grille, int x, int y) {
		while (grille.grid[x][y - 1] == Grille.DESTRUCTIBLE || grille.grid[x][y - 1] == Grille.SPECIAL || grille.grid[x][y - 1] == Grille.LEMMINGDESTRUCTIBLE) {
            if (grille.grid[x][y - 1] == Grille.INDESTRUCTIBLE)
                return;
            if (grille.grid[x][y - 1] == Grille.SPECIAL)
                lemming.moveSpecial();
            if (grille.grid[x][y - 1] == Grille.LEMMINGDESTRUCTIBLE) {
				lemming.remettreEmpty();
				lemming.moveExplosion();
            }
            lemming.moveLeft();
        }
        if (grille.grid[x][y - 1] == Grille.EMPTY || grille.grid[x + 1][y - 1] == Grille.EMPTY) {
        	lemming.moveLeft();
            lemming.setState(new Marcheur(lemming));
        }
        lemming.setLeft(true);
	}
}
