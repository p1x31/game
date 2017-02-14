import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends GameObject {

	
	int counter;
	private Handler handler;
	public Enemy(int x, int y, int size, int hp, Handler handler) {
		super(x, y, ID.Enemy, size, hp);
		velX = 3;
		velY = 3;
		//velY = 20;
		this.handler = handler;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		if ((x < 20) || (x > 1580)){
			velX = -velX;
		}	
		if ((y < 10) || (y > 510)){
			velY = - velY;
		}
		counter ++;
		
		if (counter % 20 == 0){
			shoot();
			counter = 0;
		
		}
		expired = healthPoint < 0 ;
		
	}

	private void shoot() {
		handler.addObject(new Danmaku(this.x, this.y, 5, 1));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x - size /2, y - size/2, size, size);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
