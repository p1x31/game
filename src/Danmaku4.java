import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Danmaku4 extends GameObject{

	/** initial x velocity*/
	int velX;
	
	/** initial y velocity*/
	int velY;
	
	/**
	 * Class Danmaku4
	 * @param x initial x coordinates
	 * @param y initial y coordinates
	 * @param width width of bullet
	 * @param height height of bullet
	 * @param hp health point
	 * @param velX initial x velocity
	 * @param velY initial y velocity
	 * @param handler handle bullets
	 */
	public Danmaku4(int x, int y, int width, int height, int hp, int velX, int velY) {
		super(x, y, ID.Danmaku, width, height, hp);
		// TODO Auto-generated constructor stub
		this.velY = velY;
		this.velX = velX;
	}
	
	/* (non-Javadoc)
	 * @see GameObject#tick()
	 */
	@Override
	public void tick() {
		x += velX;
		y += velY; // Traveling speed of missile
		expired = y > 950 || healthPoint < 0 || x < 0 || x > 1580 || y < 0; //removes missle if it reaches edge
	}
	
	/* (non-Javadoc)
	 * @see GameObject#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRoundRect(x - width /2 , y - height /2, width, height, 5, 5);
		
	}

}


