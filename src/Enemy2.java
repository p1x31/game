import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy2 extends GameObject {

	
	int counter;
	private Handler handler;
	public Enemy2(int x, int y, int size, int hp, Handler handler) {
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
		if(healthPoint > 5)
		{
		if (x < 20)
		{
			velX = 2;
			x = 21;
		}
		else if (x>1580)
		{
			velX = -2; //velX>0 ? -velX : velX;
			x = 1580;
		} 
		else
		{
			velX = x > 350 && x < 1350 ? (Math.abs(velX) == 4 ? velX : velX * 2) : (Math.abs(velX) == 2 ? velX : velX / 2);
		}
		if(y < 20)
		{
			velY = 2;
			y = 21;
		}
		else if(y > 500)
		{
			velY = -2;
			y = 500;
		}
		else
		{
			velY = y > 20 && y < 425 ? (Math.abs(velY) == 4 ? velY : velY * 2) : (Math.abs(velY) == 2 ? velY : velY / 2);
		}
		}
		else
		{
			velY = 6;
			velX = 0;
		}
		System.out.println(y);
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
