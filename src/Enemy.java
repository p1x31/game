import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends GameObject {

	

	public Enemy(int x, int y, int size, int hp) {
		super(x, y, ID.Enemy, size, hp);
		velX = 0;
		//velY = 20;
	}
	public void damageCheck(int projX, int projY){
		if(((projX - x) < size) &&((projY - y) < size))
		this.healthPoint --;
	}
	@Override
	public void tick() {
		x += velX;
		y += velY;
		if ((x < 20) || (x > 620)){
			velX = -velX;
		}	
		
		expired = healthPoint == 0 ;
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x - size /2, y - size/2, size, size);
	}

}
