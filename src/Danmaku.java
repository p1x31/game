import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;


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
	public Danmaku(int x, int y, int size, int hp) {
		super(x, y, ID.PlayerProjectile, size, 1);
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
		expired = y < 480 || healthPoint < 0; //removes missle if it reaches edge
	}
	
	/* (non-Javadoc)
	 * @see GameObject#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRoundRect(x - size /2 , y - size /2, size, size, 5, 5);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, size, size);
	}
}

