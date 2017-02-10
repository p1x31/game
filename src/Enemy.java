import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GameObject {

	
	int counter;
	public Enemy(int x, int y, int size, int hp) {
		super(x, y, ID.Enemy, size, hp);
		velX = 3;
		velY = 3;
		//velY = 20;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		if ((x < 20) || (x > 620)){
			velX = -velX;
		}	
		if ((y < 10) || (y > 210)){
			velY = - velY;
		}
		counter ++;
		if (counter > 20){
			shoot();
			counter = 0;
		}
		expired = healthPoint < 0 ;
		
	}

	private boolean shoot() {
		return true;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x - size /2, y - size/2, size, size);
	}

}
