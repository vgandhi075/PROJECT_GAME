package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel {

	// background
	ImageIcon background = new ImageIcon("Resources/background_medieval.JPG");

	// for lifeBar Mage
	ImageIcon lifeBarMage = new ImageIcon("Resources/lifebarMage.PNG");
	Rectangle lifeBarMages = new Rectangle();
	Rectangle lives_a = new Rectangle(58, 60, 300, 30);
	Rectangle lives_a_avalaible = new Rectangle(58, 60, 300, 30);
	int mageWidth;
	int mageHeight;
	int lifesA = 100; // progress HP mage

	// for lifebar archer
	ImageIcon lifeBarArcher = new ImageIcon("Resources/lifebarArcher.PNG");
	Rectangle lifeBarArchers = new Rectangle();
	Rectangle lives_b = new Rectangle(748, 60, 300, 30);
	Rectangle lives_b_avalaible = new Rectangle(548, 60, 300, 30);
	int archerWidth;
	int archerHeight;
	int lifesB = 100; // progress HP archer

	// cloud
	ImageIcon cloud1 = new ImageIcon("Resources/cloudy.PNG");
	Rectangle cloudr = new Rectangle();

	// power bar
	Rectangle pwrBarMage = new Rectangle(200, 200, 0, 20);
	Rectangle pwrBarArcher = new Rectangle(500, 200, 0, 20);

	public Background() {
		// cloud
		cloudr.x = 60;
		cloudr.y = 50;

		// life bar Mage(kiri)
		mageWidth = lifeBarMage.getIconWidth();
		mageHeight = lifeBarMage.getIconHeight();
		lifeBarMages.x = 0;
		lifeBarMages.y = -36;
		lifeBarMages.width = mageWidth;
		lifeBarMages.height = mageHeight;

		// life bar archer(kanan)
		archerWidth = lifeBarArcher.getIconWidth();
		archerHeight = lifeBarArcher.getIconHeight();
		lifeBarArchers.x = 510;
		lifeBarArchers.y = -33;
		lifeBarArchers.width = archerWidth;
		lifeBarArchers.height = archerHeight;

		add(new Player());
		thCloud.start();		
	}

	Thread thCloud = new Thread(() -> {
		while (true) {

			if (cloudr.x == 60) {
				do {
					cloudr.x += 5;
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
					repaint();
				} while (cloudr.x < 300);
			} else if (cloudr.x == 300) {
				do {
					cloudr.x -= 5;
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
					repaint();
				} while (cloudr.x > 60);
			}
		}
	});
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// background
		g.drawImage(background.getImage(), 0, 0, 900, 600, null);

		// cloud
		g.drawImage(cloud1.getImage(), cloudr.x, cloudr.y, 200, 100, null);
		g.drawImage(cloud1.getImage(), (cloudr.x) + 300, cloudr.y, 100, 50, null);
		g.drawImage(cloud1.getImage(), (cloudr.x) + 600, cloudr.y, 200, 100, null);
		g.drawImage(cloud1.getImage(), (cloudr.x) + 800, cloudr.y, 100, 50, null);

		// lives
		g.setColor(Color.white);
		g.fillRect(lives_a_avalaible.x, lives_a_avalaible.y, lives_a_avalaible.width, lives_a_avalaible.height);
		g.fillRect(lives_b_avalaible.x, lives_b_avalaible.y, lives_b_avalaible.width, lives_b_avalaible.height);
		g.setColor(Color.red);
		g.fillRect(lives_a.x, lives_a.y, lifesA, lives_a.height);
		g.fillRect(lives_b.x, lives_b.y, lifesB, lives_b.height);
		g.drawImage(lifeBarMage.getImage(), lifeBarMages.x, lifeBarMages.y, lifeBarMages.x + mageWidth - 500,
				lifeBarMages.y + mageHeight - 350, 0, 0, mageWidth, mageHeight, null);
		g.drawImage(lifeBarArcher.getImage(), lifeBarArchers.x, lifeBarArchers.y, lifeBarArchers.x + archerWidth - 500,
				lifeBarArchers.y + archerHeight - 350, 0, 0, archerWidth, archerHeight, null);

	};
}
