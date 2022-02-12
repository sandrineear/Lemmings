package Lemming;

import java.util.ArrayList;

public class Game {
	public static ArrayList<LemmingObservable> listLemming;
	private Grille grille;

	private int nbLemmingEnter;
	private int count;

	public Game() {
		this.grille = new Grille();
		this.listLemming = new ArrayList<>();
		this.nbLemmingEnter = 1;
		this.count = 0;
	}

	public void lemmingsEnter() {
		int nbAttente = 3;
		if (count < nbLemmingEnter*nbAttente) {
			if(count%nbAttente == 0) {
				listLemming.add(new LemmingObservable(5, 2, this));
				listLemming.add(new LemmingObservable(2, 10, this));
				listLemming.add(new LemmingObservable(11, 14, this));
				listLemming.add(new LemmingObservable(15, 5, this));
			}
			count++;
		}
	}

	public void step() {
		lemmingsEnter();
		ArrayList<LemmingObservable> buffer = new ArrayList<>();
		for (LemmingObservable current : listLemming) {
			current.move();
//			System.out.println("(" + current.getX() + "," + current.getY() +")");
			if (current.getEstMort() || current.getSorti()) {
				grille.grid[current.getX()][current.getY()] = 0;
				buffer.add(current);
			}
		}
		for (LemmingObservable current : buffer)
			listLemming.remove(current);
	}

	public Grille getGrille() {
		return grille;
	}

	public void setGrille(Grille grille) {
		this.grille = grille;
	}

	public static ArrayList<LemmingObservable> getLemming() {
		return listLemming;
	}
}
