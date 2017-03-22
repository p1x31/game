import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Enemy5 extends GameObject{
	/**
	 * firing rate
	 */
	int counter;
	
	/**
	 * handler bullets
	 */
	Handler handler;
	
	/**
	 * Class for enemy5
	 * @param x initial x coordinates
	 * @param y initial y coordinates
	 * @param width width of enemy5
	 * @param height height of enemy5
	 * @param hp health point
	 * @param handler handle bullets
	 */
	public Enemy5(int x, int y, int width, int height, int hp, Handler handler) {
		super(x, y, ID.Enemy, width, height, hp);
		// TODO Auto-generated constructor stub
		velX = 2;
		velY = 4;
		this.handler = handler;
	}


	/**
	 * update actions
	 */
	@Override
	public void tick() {
		x += velX;
		y += velY;

		if(y > 310) {
			velY = 0;
			if ((x < 20) || (x > 1580)){
				velX = -velX;
			}	
		}
		/**
		if ((y < 20) || (y > 210)){
			velY = - velY;
		}
		*/
		counter ++;
		
		if (counter % 20 == 0){
			shoot();
			counter = 0;
		
		}
		expired = healthPoint < 0 ;
		if(y > 1000) expired = true;
		
	}

	/**
	 * shoot different bullets at different positions
	 */
	private void shoot() {
			if(x >720 && x < 840){
		
			handler.addObject(new Danmaku5(this.x, this.y, 20, 20, 1, 3, 0, handler));
			handler.addObject(new Danmaku5(this.x, this.y, 20, 20, 1, -3, 0, handler));
		}
			else if(x > 400 && x < 550 || x > 1010 && x < 1300)
			{
				Random ran = new Random();
				int x = ran.nextInt(4);
				int y = ran.nextInt(4);
				if(x != 0 && y != 0)
				{
						handler.addObject(new Danmaku6(this.x, this.y, 10, 10, 1, x, y,handler));
						handler.addObject(new Danmaku6(this.x, this.y, 10, 10, 1, -x, -y, handler));
						handler.addObject(new Danmaku6(this.x, this.y, 10, 10, 1, x, -y, handler));
						handler.addObject(new Danmaku6(this.x, this.y, 10, 10, 1, -x, y, handler));
				}
			}
		    else
		    {
			   for(int i = -3; i < 3; i ++)
			     {
				for(int j = 1; j < 3; j++){
					if(i != 0 && j != 0 && i != j){
						handler.addObject(new Danmaku4(this.x, this.y, 5, 5,  1, i, j));
					}
				}
			     }
		    }
		

	}

	/**
	 * implement graphs
	 */
	@Override
	public void render(Graphics g) {
		Image img = new ImageIcon(this.getClass().getResource("/enemy4.png")).getImage();
		g.drawImage(img, x - width/2, y - height/2, width, height, null);
	}


}