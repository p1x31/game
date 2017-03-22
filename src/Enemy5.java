import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy5 extends GameObject{
	int counter;
	Handler handler;
	Player p;
	public Enemy5(int x, int y, int width, int height, int hp, Handler handler, Player p) {
		super(x, y, ID.Enemy, width, height, hp);
		// TODO Auto-generated constructor stub
		velX = 2;
		velY = 4;
		this.handler = handler;
	}


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

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x - width /2, y - height/2, width, height);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}


}