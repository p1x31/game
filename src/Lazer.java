import java.awt.Color;
import java.awt.Graphics;

public class Lazer extends GameObject {
	private int temp = 0;
	public Lazer(int x, int y, ID id, int size) {
		super(x, y, id, size, 1);
	}

	@Override
	public void tick() {
		temp ++;
		expired = temp > 10 ? true: false;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRoundRect(x, 0 , 30, y, 10, 10);
		
	}

}
