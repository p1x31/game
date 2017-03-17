import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Enemy4 extends GameObject {

	private Handler handler;
	int counter;
	public Enemy4(int x, int y, int width, int height, int hp) {
		super(x, y, ID.Enemy, width, height, hp);
		velX = 1;
		//velY = 20;
	}
	
	
	@Override
	public void tick() {
		//x += velX;
		//y += velY;
		/**
		if ((x < 20) || (x > 620)){
			velX = -velX;
		}	
		if ((y < 20) || (y > 210)){
			velY = - velY;
		}
		*/
		
		System.out.println(x);
		for(int i = 0; i < handler.object.size(); i ++)
		{
			GameObject temp = handler.object.get(i);
			if(temp.getId() == ID.Player)
			{
				Player tempPlayer = (Player)temp;
				System.out.println(x);
				if(x < tempPlayer.getX()) x++;
				else if(x > tempPlayer.getX()) x--;
				else if(y > tempPlayer.getY()) y++;
				else if(y < tempPlayer.getY()) y--;
			}
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
		g.fillRect(x - width /2, y - height/2, width, height);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
