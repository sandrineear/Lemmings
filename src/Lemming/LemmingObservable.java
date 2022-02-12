package Lemming;
import java.util.ArrayList;
import java.util.List;

public class LemmingObservable implements ILemming {

	private Lemming lemming;
	private List<LemmingObserver> observers;
	
	public LemmingObservable(int x, int y, Game game) {
		lemming = new Lemming(x, y, game.getGrille(), 0);
		observers = new ArrayList<>();
	}
	
	@Override
	public void move() {
		lemming.move();
		notifyObservers();
	}
	
	public void register(LemmingObserver o) {
		observers.add(o);
	}

	public void unregister(LemmingObserver o) {
		observers.remove(o);
	}

	void notifyObservers() {
		for (LemmingObserver lemmingObserver : observers) {
			lemmingObserver.update();
		}
	}
	
	@Override
	public void testLaveSortie() {
		lemming.testLaveSortie();
	}
	
	@Override
	public boolean isLemming(int posX, int posY) {
		return this.lemming.isLemming(posX, posY);
	}

	@Override
	public boolean isLave(ILemming lemming) {
		return this.lemming.isLave(lemming);
	}

	@Override
	public boolean isSorti(ILemming lemming) {
		return this.lemming.isSorti(lemming);
	}

	@Override
	public boolean isChute(ILemming lemming) {
		return this.lemming.isChute(lemming);
	}

	@Override
	public void moveRight() {
		lemming.moveRight();
	}
	
	@Override
	public void moveLeft() {
		lemming.moveLeft();
	}
	
	@Override
	public void moveBottom() {
		lemming.moveBottom();
	}
	
	@Override
	public void moveTop() {
		lemming.moveTop();
	}
	
	@Override
	public void moveTopRight() {
		lemming.moveRight();
	}
	
	@Override
	public void moveTopLeft() {
		lemming.moveLeft();
	}
	
	@Override
	public void teleportation() {
		lemming.teleportation();
	}

	@Override
	public void moveSpecial() {
		lemming.moveSpecial();
	}
	
	@Override
	public void moveExplosion() {
		lemming.moveExplosion();
	}

	@Override
	public void remettreEmpty() {
		lemming.remettreEmpty();
	}

	@Override
	public void moveLemming() {
		lemming.moveLemming();
	}

	@Override
	public void toRight() {
		lemming.toRight();
	}

	@Override
	public void toLeft() {
		lemming.toLeft();
	}

	@Override
	public void toTop() {
		lemming.toTop();
	}

	@Override
	public void toBottom() {
		lemming.toBottom();
	}

	@Override
	public boolean getEstMort() {
		return lemming.getEstMort();
	}

	@Override
	public void setEstMort(boolean estMort) {
		lemming.setEstMort(estMort);
	}

	@Override
	public boolean getSorti() {
		return lemming.getSorti();
	}

	@Override
	public int getX() {
		return lemming.getX();
	}

	@Override
	public int getY() {
		return lemming.getY();
	}

	@Override
	public void setX(int x) {
		lemming.setX(x);
	}

	@Override
	public void setY(int y) {
		lemming.setY(y);
	}

	@Override
	public int getClique() {
		return lemming.getClique();
	}

	@Override
	public void setClique(int clique) {
		lemming.setClique(clique);
	}

	@Override
	public LemmingState getState() {
		return lemming.getState();
	}
	
	@Override
	public void setState(LemmingState state) {
		lemming.setState(state);
	}
	
	@Override
	public Grille getGrid() {
		return lemming.getGrid();
	}

	@Override
	public boolean isLeft() {
		return lemming.isLeft();
	}

	@Override
	public void setLeft(boolean isLeft) {
		lemming.setLeft(isLeft);
	}
	
	@Override
	public int getTempsEcoule() {
		return lemming.getTempsEcoule();
	}

	@Override
	public void setTempsEcoule(int tempsEcoule) {
		lemming.setTempsEcoule(tempsEcoule);
	}
}
