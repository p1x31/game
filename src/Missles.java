import java.awt.Color;
import java.awt.Graphics;

public class Missles extends GameObject{

	private int temp;
	public Missles(int x, int y, ID id, int size) {
		super(x, y, id, size, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		//x
		y += -3;
		temp += y;
		expired = temp < 0 ? true: false;
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRoundRect(x, y, size, size, 5, 5);
		
	}

}
