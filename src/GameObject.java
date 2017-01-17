import java.awt.Graphics;



public abstract class GameObject{

	
	protected int x,y;
	protected ID id;
	protected int velX, velY;
	protected int size;
	protected boolean expired;
	protected int healthPoint;
	protected int objectState;
	
	
	public int getHealthPoint() {
		return healthPoint;
	}

	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public int getSize() {
		return size;
	}

	public int getObjSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}
	
	public void setSpeed(int x, int y){
		this.velX = x;
		this.velY = y;
		
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}

	public GameObject(int x, int y, ID id, int size, int hp) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.size = size;
		this.healthPoint = hp;
		this.objectState = 1;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public ID getId() {
		return id;
	}


	public void setId(ID id) {
		this.id = id;
	}
	
	
	
	
}
