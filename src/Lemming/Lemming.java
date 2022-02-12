package Lemming;

public class Lemming implements ILemming {
	private boolean estMort;
	private boolean sorti;
	private boolean isLeft;
	private int hauteurMortelle;
	private int compteurChute;
	private int x, y;
	public static int compteSortie;
	private int clique;
	private int tempsEcoule;

	private Direction direction;
	private Grille grille;
	private LemmingState state;
	private Game game;

	public Lemming(int x, int y, Grille grille, int clique) {
		this.estMort = false;
		this.sorti = false;
		this.isLeft = false;
		this.hauteurMortelle = 5;
		this.compteurChute = 1;
		this.x = x;
		this.y = y;
		this.compteSortie = 0;
		this.clique = clique;
		this.direction = Direction.Right;
		this.grille = grille;
		this.state = new Marcheur(this);
		this.tempsEcoule = 0;
	}

	public void changeState() {
		if (GameView.bloquer == true) {
			state = new Bloqueur(this);
		} else if (GameView.creuser == true) {
			state = new Tunnelier(this);
		} else if (GameView.grimper == true) {
			state = new Grimpeur(this);
		} else if (GameView.forer == true) {
			state = new Foreur(this);
		} else if (GameView.construire == true) {
			state = new Charpentier(this);
		} else if (GameView.exploser == true) {
			state = new Bombeur(this);
		} else if (GameView.parachuter == true) {
			state = new Parachutiste(this);
		} else if (GameView.marcher == true) {
			state = new Marcheur(this);
		}
	}

	@Override
	public void testLaveSortie() {
		isLave(this);
		isSorti(this);
		teleportation();
	}

	@Override
	public boolean isLemming(int posX, int posY) {
		if (this.x == posX && this.y == posY) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isLave(ILemming lemming) {
		if (grille.grid[x + 1][y] == Grille.LAVE || grille.grid[x - 1][y] == Grille.LAVE
				|| grille.grid[x][y + 1] == Grille.LAVE || grille.grid[x][y - 1] == Grille.LAVE) {
			remettreEmpty();
			estMort = true;
			return true;
		}
		return false;
	}

	@Override
	public boolean isSorti(ILemming lemming) {
		if (grille.grid[x + 1][y] == Grille.SORTIE || grille.grid[x - 1][y] == Grille.SORTIE
				|| grille.grid[x][y + 1] == Grille.SORTIE || grille.grid[x][y - 1] == Grille.SORTIE) {
			this.sorti = true;
			remettreEmpty();
			compteSortie++;
			return true;
		}
		return false;
	}

	@Override
	public boolean isChute(ILemming lemming) {
		if (grille.grid[x + 1][y] == Grille.EMPTY || grille.grid[x + 1][y] == Grille.LEMMING) {
			if (compteurChute < hauteurMortelle) {
				compteurChute++;
				return false;
			}
			remettreEmpty();
			estMort = true;
		}
		compteurChute = 1;
		return true;
	}

	@Override
	public void teleportation() {
		if (grille.grid[x][y + 1] == Grille.TELEPORT || grille.grid[x][y - 1] == Grille.TELEPORT
				|| grille.grid[x + 1][y] == Grille.TELEPORT || grille.grid[x - 1][y] == Grille.TELEPORT) {
			remettreEmpty();
			setX(2);
			setY(16);
			moveLemming();
			return;
		}
	}

	@Override
	public void moveSpecial() {
		for (int i = 13; i < 16; i++) {
			grille.grid[12][i] = Grille.DESTRUCTIBLE;
		}
	}

	@Override
	public void moveExplosion() {
		for (int i = x - 2; i <= x + 2; i++) {
			for (int j = y - 2; j <= y + 2; j++) {
				for (LemmingObservable l : game.getLemming()) {
					if (l.getX() == i && l.getY() == j) {
						estMort = true;
						l.setEstMort(true);
					}					
				}
			}
		}
	}

	@Override
	public void move() {
		state.move();
	}

	@Override
	public void remettreEmpty() {
		grille.grid[x][y] = Grille.EMPTY;
	}

	@Override
	public void moveLemming() {
		grille.grid[x][y] = Grille.LEMMING;
	}

	@Override
	public void moveRight() {
		remettreEmpty();
		toRight();
		moveLemming();
	}

	@Override
	public void moveLeft() {
		remettreEmpty();
		toLeft();
		moveLemming();
	}

	@Override
	public void moveBottom() {
		remettreEmpty();
		toBottom();
		moveLemming();
	}

	@Override
	public void moveTop() {
		remettreEmpty();
		toTop();
		moveLemming();
	}

	@Override
	public void moveTopRight() {
		remettreEmpty();
		toTop();
		toRight();
		moveLemming();
	}

	@Override
	public void moveTopLeft() {
		remettreEmpty();
		toTop();
		toLeft();
		moveLemming();
	}

	@Override
	public void toRight() {
		y++;
	}

	@Override
	public void toLeft() {
		y--;
	}

	@Override
	public void toTop() {
		x--;
	}

	@Override
	public void toBottom() {
		x++;
	}

	@Override
	public boolean getEstMort() {
		return estMort;
	}

	@Override
	public void setEstMort(boolean estMort) {
		this.estMort = estMort;
	}

	@Override
	public boolean getSorti() {
		return sorti;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int getClique() {
		return clique;
	}

	@Override
	public void setClique(int clique) {
		this.clique = clique;
	}
	
	@Override
	public LemmingState getState() {
		return state;
	}

	@Override
	public void setState(LemmingState state) {
		this.state = state;
	}

	@Override
	public Grille getGrid() {
		return this.grille;
	}

	@Override
	public boolean isLeft() {
		return isLeft;
	}

	@Override
	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	@Override
	public int getTempsEcoule() {
		return tempsEcoule;
	}

	@Override
	public void setTempsEcoule(int tempsEcoule) {
		this.tempsEcoule = tempsEcoule;
	}
}
