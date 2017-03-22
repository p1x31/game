import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy2 extends GameObject {

	/**
	 * firing rate
	 */
	int counter;
	/**
	 * handler bullets
	 */
	private Handler handler;
	
	/**
	 * the class enemy2
	 * @param x initial x coordinates
	 * @param y initial y coordinates
	 * @param width width of enemy2
	 * @param height height of enemy2
	 * @param velX initial x velocity 
	 * @param velY initial y velocity
	 * @param hp health point
	 * @param handler handle bullets
	 */
	public Enemy2(int x, int y, int width, int height, int velX, int velY, int hp, Handler handler) {
		super(x, y, ID.Enemy, width, height, hp);
		this.velX = velX;
		this.velY = velY;
		this.handler = handler;
	}

	/**
	 * update any action
	 */
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

	/**
	 * shoot bullets
	 */
	private void shoot() {
		handler.addObject(new Danmaku(this.x, this.y, 5, 5, 1));
		//handler.addObject(new Danmaku2(this.x, this.y, 5, 5, 1));
		//handler.addObject(new Danmaku3(this.x, this.y, 5, 5, 1));

	}

	/**
	 * implement graph
	 */
	@Override
	public void render(Graphics g) {
		Image img = new ImageIcon(this.getClass().getResource("/enemy2.png")).getImage();
		g.drawImage(img, x - width/2, y - height/2, width, height, null);
	}

	
	

}
