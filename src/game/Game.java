package game;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Game extends JFrame{

	public Game() {
		setSize(900, 600);
		setFocusable(true);
//		add(new Player());
		add(new Background());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Game();
	}

}
