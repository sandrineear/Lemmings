package Lemming;

public interface ILemming {
	
	void testLaveSortie();

	boolean isLemming(int posX, int posY);

	boolean isLave(ILemming lemming);

	boolean isSorti(ILemming lemming);

	boolean isChute(ILemming lemming);

	void teleportation();

	void moveSpecial();
	
	void moveExplosion();

	void move();

	void remettreEmpty();

	void moveLemming();

	void moveRight();
	
	void moveLeft();
	
	void moveBottom();
	
	void moveTop();
	
	void moveTopRight();
	
	void moveTopLeft();
	
	void toRight();

	void toLeft();

	void toTop();

	void toBottom();

	boolean getEstMort();

	void setEstMort(boolean estMort);

	boolean getSorti();

	int getX();

	int getY();

	void setX(int x);

	void setY(int y);

	int getClique();

	void setClique(int clique);
	
	LemmingState getState();

	void setState(LemmingState state);

	Grille getGrid();
	
	boolean isLeft();

	void setLeft(boolean isLeft);
	
	int getTempsEcoule();
		
	void setTempsEcoule(int tempsEcoule);
}