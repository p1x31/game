import java.awt.Color;
import java.awt.Graphics;


public class Player extends GameObject{
	
	public Player(int x, int y, ID id, int size, int hp) {
		super(x, y, id, size, hp);
	}

	
	public static final int FULL = 1;
	public static final int INVI = 2;
	public static final int DOWN = 0;
	
	public void changeState(int i){
		this.objectState = i;
	}
	
	@Override
	public void tick() {

		x += velX;
		y += velY;
		
		expired = healthPoint == 0 ? true : false;
	}
		@Override
	public void render(Graphics g) {
		if(id == ID.Player1){
			g.setColor(Color.blue);
		} else if (id == ID.Player2){
			g.setColor(Color.red);
		}
		g.fillRect(x - size/2, y - size/2, size, size);
	}

}
