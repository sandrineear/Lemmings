package Lemming;

import javax.swing.JFrame;

public class App {
	private static final int WIDTH = 620;
	private static final int HEIGHT = 437;

	public static void main(String[] args) {
		Game game = new Game();
		GameView gameView = new GameView(game);
		JFrame frame = new JFrame("Lemmings");
		
		frame.add(gameView);
		frame.setContentPane(gameView);
		frame.pack();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	 
		gameView.display(game, gameView, frame);
		try {
			while (true) {
				game.step();
				gameView.update();
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
