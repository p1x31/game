import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.ImageIcon;


public class Danmaku extends GameObject{

// TODO: Auto-generated Javadoc
/**
 * The Enemy Missile.
 */

	/** Temp value. */
	private int temp;
	
	/**
	 * Instantiates a new missile.
	 *
	 * @param x the x
	 * @param y the y
	 * @param size the size
	 */
	public Danmaku(int x, int y, int width, int height, int hp) {
		super(x, y, ID.Danmaku, width, height, hp);
		// TODO Auto-generated constructor stub
		this.velY =5;
	}

	/* (non-Javadoc)
	 * @see GameObject#tick()
	 */
	@Override
	public void tick() {
		//x
		y += velY; // Traveling speed of missile
		expired = y > 1000 || healthPoint < 0; //removes missle if it reaches edge
	}
	
	/* (non-Javadoc)
	 * @see GameObject#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		Image img = new ImageIcon(this.getClass().getResource("/barrage.png")).getImage();
		g.drawImage(img, x - width/2, y - height/2, width, height, null);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
}

