import javax.swing.*;
import java.awt.*;

public class PlayerNet {

	private int x, y, op_x, op_y;
	public String name;
	public String op_name;
	public boolean win;
	private Image player, opponent;
	public String path = "./img/";

	public PlayerNet(String name){
		this.name = name;
		if(name.equals("P1")){
			this.op_name = "P2";
			x = 1;
			y = 39;
			op_x = 39;
			op_y = 39;
		}

		if(name.equals("P2")){
			this.op_name = "P1";
			x = 39;
			y = 39;
			op_x = 1;
			op_y = 39;
		}

		ImageIcon img = new ImageIcon(path + "player.png");
		player = img.getImage();

		ImageIcon opp = new ImageIcon(path + "player_2.png");
		opponent = opp.getImage();
	}

	public Image getPlayer(){
		return player;
	}

	public Image getOpponent(){
		return opponent;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public void move(int dx, int dy){
		x += dx;
		y += dy;
	}

	public int getOpX(){
		return op_x;
	}

	public int getOpY(){
		return op_y;
	}

	public String getOpName(){
		return op_name;
	}

	public void moveOpponent(int dopx, int dopy){
		op_x = dopx;
		op_y = dopy;
	}
}
