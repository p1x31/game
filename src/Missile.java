import java.awt.Color;
import java.awt.Graphics;

// TODO: Auto-generated Javadoc
/**
 * The Weapon Class Missile.
 */
public class Missile extends GameObject{

	/** Temp value. */
	private int temp;
	
	/**
	 * Instantiates a new missile.
	 *
	 * @param x the x
	 * @param y the y
	 * @param size the size
	 */
	public Missile(int x, int y, int size) {
		super(x, y, ID.PlayerProjectile, size, 1);
		// TODO Auto-generated constructor stub
		this.velY = -3;
	}

	/* (non-Javadoc)
	 * @see GameObject#tick()
	 */
	@Override
	public void tick() {
		//x
		y += velY; // Traveling speed of missile

		expired = y < 0 || healthPoint < 0? true: false; //removes missle if it reaches edge


	}
	
	/* (non-Javadoc)
	 * @see GameObject#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRoundRect(x - size/2, y - size/2, size, size, 5, 5);
		
	}

}
