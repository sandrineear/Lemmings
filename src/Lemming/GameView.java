package Lemming;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class GameView extends JComponent implements LemmingObserver {
	private static final long serialVersionUID = 1L;

	static boolean bloquer = false;
	static boolean construire = false;
	static boolean grimper = false;
	static boolean forer = false;
	static boolean creuser = false; // tunnelier
	static boolean exploser = false;
	static boolean parachuter = false;
	static boolean marcher = false;
	
	private static final int SCALE = 20;
	private Game game;
	
	public GameView(Game game) {
		setBackground(Color.WHITE);
		this.game = game;
	}

	public void paint(Graphics g) {
		super.paint(g);
		drawGrid(g);
		drawCompteur(g);
	}
	
	public void drawCompteur(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);
		g.drawString("Lemmings survivants:" + Lemming.compteSortie, 22*SCALE, 18*SCALE);
	}
	
	public void display(Game game, GameView gameView, JFrame frame) {
		CheckboxGroup groupe = new CheckboxGroup();
		Checkbox bloqueur = new Checkbox("Bloqueur", groupe, false);
		Checkbox bombeur = new Checkbox("Bombeur", groupe, false);
		Checkbox charpentier = new Checkbox("Charpentier", groupe, false);
		Checkbox foreur = new Checkbox("Foreur", groupe, false);
		Checkbox grimpeur = new Checkbox("Grimpeur", groupe, false);
		Checkbox parachutiste = new Checkbox("Parachutiste", groupe, false);
		Checkbox tunnelier = new Checkbox("Tunnelier", groupe, false);
		Checkbox marcheur = new Checkbox("Marcheur", groupe, false);

		bloqueur.setBounds(450, 20, 120, 30);
		bombeur.setBounds(450, 60, 120, 30);
		charpentier.setBounds(450, 100, 120, 30);
		foreur.setBounds(450, 140, 120, 30);
		grimpeur.setBounds(450, 180, 120, 30);
		parachutiste.setBounds(450, 220, 120, 30);
		tunnelier.setBounds(450, 260, 120, 30);
		marcheur.setBounds(450, 300, 120, 30);

		frame.add(bloqueur);
		frame.add(bombeur);
		frame.add(charpentier);
		frame.add(foreur);
		frame.add(grimpeur);
		frame.add(parachutiste);
		frame.add(tunnelier);
		frame.add(marcheur);
		frame.setLayout(null);

		MouseAdapter ma = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int x = e.getX() / SCALE;
				int y = e.getY() / SCALE;
				for (LemmingObservable lemming : game.getLemming()) {
					if (x == lemming.getY() && y == lemming.getX()) {
						if (lemming.isLemming(y, x) == true) {
							lemming.setClique(1);
							bloquer = bloqueur.getState();
							creuser = tunnelier.getState();
							grimper = grimpeur.getState();
							forer = foreur.getState();
							construire = charpentier.getState();
							exploser = bombeur.getState();
							parachuter = parachutiste.getState();
							marcher = marcheur.getState();
							break;
						}
					}
					lemming.setClique(0);
				}
			}
		};
		gameView.addMouseListener(ma);
	}

	public void drawGrid(Graphics g) {
		for (int w = 0; w < 20; w++) {
			for (int z = 0; z < 20; z++) {
				switch (game.getGrille().getGrid()[z][w]) {
				case Grille.EMPTY:
					g.setColor(Color.WHITE);
					g.fillRect(SCALE * w, SCALE * z, SCALE, SCALE);
					break;
				case Grille.DESTRUCTIBLE:
					g.setColor(new Color(122, 61, 30));
					g.fillRect(SCALE * w, SCALE * z, SCALE, SCALE);
					break;
				case Grille.LAVE:
					g.setColor(new Color(225, 50, 50));
					g.fillRect(SCALE * w, SCALE * z, SCALE, SCALE);
					break;
				case Grille.ENTREE:
					g.setColor(new Color(151, 243, 155));
					g.fillRect(SCALE * w, SCALE * z, SCALE, SCALE);
					break;
				case Grille.SORTIE:
					g.setColor(new Color(171, 153, 255));
					g.fillRect(SCALE * w, SCALE * z, SCALE, SCALE);
					break;
				case Grille.LEMMING:
					g.setColor(new Color(255, 204, 51));
					g.fillRect(SCALE * w, SCALE * z, SCALE, SCALE);
					break;
				case Grille.BORD:
					g.setColor(Color.BLACK);
					g.fillRect(SCALE * w, SCALE * z, SCALE, SCALE);
					break;
				case Grille.TELEPORT:
					g.setColor(Color.PINK);
					g.fillRect(SCALE * w, SCALE * z, SCALE, SCALE);
					break;
				case Grille.SPECIAL:
					g.setColor(Color.MAGENTA);
					g.fillRect(SCALE * w, SCALE * z, SCALE, SCALE);
					break;
				case Grille.INDESTRUCTIBLE:
					g.setColor(Color.GRAY);
					g.fillRect(SCALE * w, SCALE * z, SCALE, SCALE);
					break;
				case Grille.LEMMINGDESTRUCTIBLE:
					g.setColor(Color.CYAN);
					g.fillRect(SCALE * w, SCALE * z, SCALE, SCALE);
					break;
				}
			}
		}
	}

	@Override
	public void update() {
		this.repaint();
	}
}
