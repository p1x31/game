import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;

public class Enemy extends GameObject {



	public Enemy(int x, int y, int size, int hp) {
		super(x, y, ID.Enemy, size, hp);
		velX = 0;
		velY = 0;
	}
	
	public void damageCheck(int projX, int projY){
		if(((projX - x) < size) &&((projY - y) < size))
		this.healthPoint --;
	}
	@Override
	public void tick(LinkedList<GameObject> object) {
		x += velX;
		y += velY;
		if ((x < 20) || (x > 620)){
			velX = -velX;
		}	
		CollisionWithProjectile(object);
		
		expired = healthPoint == 0 ;
		
	}
	
	private void CollisionWithProjectile(LinkedList<GameObject> object){
	    for(int i=0; i<Handler.object.size();i++){
	        GameObject temp = Handler.object.get(i);
	        if(temp.getId() == ID.PlayerProjectile){
	                if(getBounds().intersects(temp.getBounds())){
	                	System.out.println("!");
	                    //velY=0;
	                    //y= temp.getY();
	                	//healthPoint--;
	                }
	    }
	    }
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x - size /2, y - size/2, size, size);
	}
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, size, size);
	}

}
