import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Danmaku6 extends GameObject{

	int velX;
	int velY;
	Handler handler;
	
	public Danmaku6(int x, int y, int width, int height, int hp, int velX, int velY, Handler handler) {
		super(x, y, ID.Danmaku, width, height, hp);
		// TODO Auto-generated constructor stub
		this.velY = velY;
		this.velX = velX;
		this.handler = handler;
	}
	
	@Override
	public void tick() {
		x += velX;
		y += velY; // Traveling speed of missile
		expired = y > 900 || healthPoint < 0 || x < 0 || x > 1580 || y < 0; //removes missle if it reaches edge
		if(expired)
		{
			shoot();
		}
	}
	
	/* (non-Javadoc)
	 * @see GameObject#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRoundRect(x - width /2 , y - height /2, width, height, 5, 5);
		
	}
	
	public void shoot()
	{
		for(int i = -2; i < 3; i++)
		{
			for(int j = -2; j < 3; j++)
			{
				if(i != 0 && j != 0)handler.addObject(new Danmaku4(this.x+10, this.y + 10, 5, 5,  1, i, j));
			}
		}

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

}

