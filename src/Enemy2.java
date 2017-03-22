import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy2 extends GameObject {

	
	int counter;
	int angle;
	private Handler handler;
	public Enemy2(int x, int y, int width, int height, int velX, int velY, int hp, Handler handler) {
		super(x, y, ID.Enemy, width, height, hp);
		this.velX = velX;
		this.velY = velY;
		this.handler = handler;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
        
		/**
		angle += 1;
		x += (float) (200 * Math.sin(velX * angle));
		y += (float) (200 * Math.cos(velY * angle));
		*/

		if(y > 500) velY = -velY;
		counter ++;
		
		if (counter % 20 == 0){
			shoot();
			counter = 0;
		
		}
		expired = healthPoint < 0 ;
		if(y > 1000 || y < 0) expired = true;
		
	}

	private void shoot() {
		handler.addObject(new Danmaku(this.x, this.y, 5, 5, 1));
		//handler.addObject(new Danmaku2(this.x, this.y, 5, 5, 1));
		//handler.addObject(new Danmaku3(this.x, this.y, 5, 5, 1));

	}

	@Override
	public void render(Graphics g) {
		Image img = new ImageIcon(this.getClass().getResource("/enemy2.png")).getImage();
		g.drawImage(img, x - width/2, y - height/2, width, height, null);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
