import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Danmaku5 extends GameObject{

	int velX;
	int velY;
	Handler handler;
	public Danmaku5(int x, int y, int width, int height, int hp, int velX, int velY, Handler handler) {
		super(x, y, ID.Danmaku, width, height, hp);
		// TODO Auto-generated constructor stub
		this.velX = velX;
		this.velY = velY;
		this.handler = handler;
	}
	
	@Override
	public void tick() {
		java.util.Timer timer = new java.util.Timer(true); 

		x += velX;
		y += velY; // Traveling speed of missile
		expired = y > 1000 || healthPoint < 0; //removes missle if it reaches edge
		if (x ==580 || x== 980 || x == 380 || x == 1180 || x == 180 || x == 1380)
		{
			velX = 0;
			velY = 0;
			shoot();
			TimerTask task = new TimerTask(){
				public void run(){
					expired = true;
				}
			};
			timer.schedule(task, 2000);
		}
		
		
	}
	private void shoot() {
		handler.addObject(new Danmaku(this.x, this.y, 16, 32, 1));
		//Music.potwak();
	}
	/* (non-Javadoc)
	 * @see GameObject#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		Image img = new ImageIcon(this.getClass().getResource("/laser.png")).getImage();
		g.drawImage(img, x - width/2, y - height/2, width, height, null);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
}
