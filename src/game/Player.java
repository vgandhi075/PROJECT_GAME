package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Player extends JPanel{
	//Mage
	ImageIcon mageImg = new ImageIcon("Resources/player_mage_idle.PNG");
	Rectangle mageRect = new Rectangle();
	int mageWidth;
	int mageHeight;
	
	//Archer
	ImageIcon archerImg = new ImageIcon("Resources/player_archer_idle.PNG");
	Rectangle archerRect = new Rectangle();
	int archerWidth;
	int archerHeight;
	
	//looping ambil gambar
	int x = 0;

	public Player() {
		// player A(kiri)
		mageWidth = mageImg.getIconWidth() / 5;
		mageHeight = mageImg.getIconHeight();

		mageRect.x = 180;
		mageRect.y = 340;
		mageRect.width = mageWidth;
		mageRect.height = mageHeight;

		// player B(kanan)
		archerWidth = archerImg.getIconWidth() / 4;
		archerHeight = archerImg.getIconHeight();

		archerRect.x = 680;
		archerRect.y = 370;
		archerRect.width = archerWidth;
		archerRect.height = archerHeight;
		
		th.start();
	}
	
	Thread th = new Thread(() -> {
		while (true) {
			x++;
			x %= 2;
			
			repaint();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	});
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(mageImg.getImage(), mageRect.x, mageRect.y, mageRect.x + mageWidth, 
				mageRect.y + mageHeight,x * mageWidth, 0, (x * mageWidth) + mageWidth, 
				mageHeight, null);
		g.drawImage(archerImg.getImage(), archerRect.x - 20, archerRect.y, archerRect.x + archerWidth,
				archerRect.y + archerHeight, x * archerWidth, 0, (x * archerWidth) + archerWidth,
				archerHeight, null);
	}

}
