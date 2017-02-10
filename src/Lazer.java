import java.awt.Color;
import java.awt.Graphics;

// TODO: Auto-generated Javadoc
/**
 * The Weapon Class Lazer.
 */
public class Lazer extends GameObject {
	
	/** The temp. */
	private int temp = 0;
	
	/**
	 * Instantiates a new lazer.
	 *
	 * @param x the x
	 * @param y the y
	 * @param size the size
	 */
	public Lazer(int x, int y, int size) {
		super(x, y, ID.PlayerProjectile, size, 1);
	}

	/* (non-Javadoc)
	 * @see GameObject#tick()
	 */
	@Override
	public void tick() {
		temp ++; // counts how long the lazer lasts for
		expired = temp > 10 ? true: false; // deletes the lazer after 10 frames
	}

	/* (non-Javadoc)
	 * @see GameObject#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRoundRect(x - 15, 0 , 30, y, 10, 10); // lazer shoots from the character to the edge of the board
		
	}

}
