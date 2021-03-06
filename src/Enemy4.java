import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Enemy4 extends GameObject{

	/**
	 * firing rate
	 */
	int counter;

	/**
	 * current player x coordinates
	 */
	int playerX;
	
	/**
	 * current player y coordiantes
	 */
	int playerY;
	
	/**
	 * player
	 */
	Player p;
	
	/**
	 * Class enemy4
	 * @param x initial x coordinates
	 * @param y initial y coordiantes
	 * @param width width of enemy4
	 * @param height height of enemy4
	 * @param hp health point
	 * @param p Player that will be tracked
	 */
	public Enemy4(int x, int y, int width, int height, int hp, Player p) {
		super(x, y, ID.Enemy, width, height, hp);
		velX = 3;
		velY = 2;
		this.p = p;
		//this.playerX = playerX;
		//this.playerY = playerY;
	}
	
	/**
	 * update any action
	 */
	@Override
	public void tick() {
		x += velX;
		y += velY;
		/**
		if ((x < 20) || (x > 620)){
			velX = -velX;
		}	
		if ((y < 20) || (y > 210)){
			velY = - velY;
		}
		*/
		int playerX = p.getX();
		int playerY = p.getY();
		if(x > playerX) {
			if(velX > 0) velX = -velX;
		}
		else if(x < playerX){
			if(velX < 0) velX = -velX;
		}
		else if(y < playerY){
			if(velY < 0) velY = -velY;
		}
		else if (y > playerY) {
			if (velY > 0) velY = -velY;
		}
		//System.out.println(x);
		//System.out.println(velX);
//		System.out.println("playery: " + playerY);
		expired = healthPoint < 0 ;
	}

	/**
	 * implement graph
	 */
	@Override
	public void render(Graphics g) {
		Image img = new ImageIcon(this.getClass().getResource("/enemy4.png")).getImage();
		g.drawImage(img, x - width/2, y - height/2, width, height, null);
	}

}
