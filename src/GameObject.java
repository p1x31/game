import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;



// TODO: Auto-generated Javadoc
/**
 * The Class GameObject.
 */
public abstract class GameObject{

	
	/** The location. */
	protected int x, y;
	
	/** The id. */
	protected ID id;
	
	/** The velocity Y. */
	protected int velX, velY;
	
	/** The hitbox. */
	protected int width, height; 
	
	/** Check expired objects. */
	protected boolean expired;
	
	/** The health point of an object. */
	protected int healthPoint;
	
	/** The object state 
	 *  prepared for different damaged states in graphics
	 */
	private int objectState;
	
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int length) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getObjectState() {
		return objectState;
	}

	public void setObjectState(int objectState) {
		this.objectState = objectState;
	}

	/**
	 * Gets the health point.
	 *
	 * @return the health point
	 */
	public int getHealthPoint() {
		return healthPoint;
	}

	/**
	 * Sets the health point.
	 *
	 * @param healthPoint the new health point
	 */
	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}

	/**
	 * Checks if is expired.
	 * Should delete the object in Handler if true
	 *
	 * @return true, if is expired
	 */
	public boolean isExpired() {
		return expired;
	}

	/**
	 * Sets the expired.
	 * Should delete the object in Handler if true
	 *
	 * @param expired the new expired
	 */
	public void setExpired(boolean expired) {
		this.expired = expired;
	}



	public boolean damageCheck(int projX, int projY, int projWidth, int projHeight){
		if((Math.abs(projX - this.x) < (this.width + projWidth)/2) &&
				(Math.abs(projY - this.y) < (this.height + projHeight)/2)){
		this.healthPoint --;
		return true;
		}
		return false;
	}


	/**
	 * Gets the velocity X.
	 *
	 * @return the velocity X
	 */
	public int getVelX() {
		return velX;
	}

	/**
	 * Sets the velocity X.
	 *
	 * @param velX the new velocity X
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}

	/**
	 * Gets the velocity Y.
	 *
	 * @return the velocity Y
	 */ 
	public int getVelY() {
		return velY;
	}
	
	/**
	 * Sets the speed.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void setSpeed(int x, int y){
		this.velX = x;
		this.velY = y;
		
	}
	
	/**
	 * Sets the velocity Y.
	 *
	 * @param velY the new velocity Y
	 */
	public void setVelY(int velY) {
		this.velY = velY;
	}

	/**
	 * Instantiates a new game object.
	 * All objects should begin with state 1: healthy
	 * 
	 * @param x the x
	 * @param y the y
	 * @param id the identifier of the object
	 * @param size the size of the object
	 * @param hp the Health point of the object
	 */
	public GameObject(int x, int y, ID id, int size, int hp) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.width = size;
		this.height = size;
		this.healthPoint = hp;
		this.objectState = 1;
	}

	/**
	 * Tick.
	 */
	public abstract void tick();
	
	/**
	 * Render.
	 *
	 * @param g the graphic
	 */
	public abstract void render(Graphics g);
	
	public abstract Rectangle getBounds();
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(int x) {
		this.x = x;
	}


	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}


	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(int y) {
		this.y = y;
	}


	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public ID getId() {
		return id;
	}


	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(ID id) {
		this.id = id;
	}
	
	
	
	
}
