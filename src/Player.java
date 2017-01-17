import java.awt.Color;
import java.awt.Graphics;


// TODO: Auto-generated Javadoc
/**
 * The Player Class.
 */
public class Player extends GameObject{
	
	/**
	 * Instantiates a new player.
	 *
	 * @param x the x
	 * @param y the y
	 * @param id the id So far cannot remove since difference between Player1 and Player2
	 * @param size the size
	 * @param hp the health point
	 */
	public Player(int x, int y, ID id, int size, int hp) {
		super(x, y, id, size, hp);
	}

	// Object states for graphics
	/** The Constant FULL. */
	public static final int FULL = 1;
	
	/** The Constant INVI. */
	public static final int INVI = 2;
	
	/** The Constant DOWN. */
	public static final int DOWN = 0;
	
	/**
	 * Change state.
	 *
	 * @param i the i
	 */
	public void changeState(int i){
		this.objectState = i;
	}
	
	/* (non-Javadoc)
	 * @see GameObject#tick()
	 */
	@Override
	public void tick() {
		// position moves according to velocity
		x += velX;
		y += velY;
		
		// when healthPoint is 0 remove/gameover
		expired = healthPoint == 0 ? true : false;
	}
		
		/* (non-Javadoc)
		 * @see GameObject#render(java.awt.Graphics)
		 */
		@Override
	public void render(Graphics g) {
			// simple player differences 
		if(id == ID.Player1){
			g.setColor(Color.blue);
		} else if (id == ID.Player2){
			g.setColor(Color.red);
		}
			//players represented by small squares
		g.fillRect(x - size/2, y - size/2, size, size);
	}

}
