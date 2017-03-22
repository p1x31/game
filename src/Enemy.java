
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy extends GameObject {

	
	int counter;
	private Handler handler;
	public Enemy(int x, int y, int width, int height, int hp, Handler handler) {
		super(x, y, ID.Enemy, width, height, hp);
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
		handler.addObject(new Danmaku(this.x, this.y, 20, 20, 1));
		Music.potwak();
	}

	@Override
	public void render(Graphics g) {
		Image img = new ImageIcon(this.getClass().getResource("/enemy1.png")).getImage();
		g.drawImage(img, x - width/2, y - height/2, width, height, null);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
