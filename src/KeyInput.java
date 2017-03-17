import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{
	private Player player;
	private Handler handler;
	private int missileCD = 0;
	private int missileSpeed = 15;
	private int speed = 5;
	private boolean up, down, left, right;
	public KeyInput(Handler handler){
		this.handler = handler;
		player = handler.getPlayer();

	}
	
	public void update(){
		player.setVelX(0);
		player.setVelY(0);
		if (up) {player.setVelY(-speed);}
		if (down) {player.setVelY(speed);}
		if (left) {player.setVelX(-speed);}
		if (right) {player.setVelX(speed);}
	}
	public void keyPressed(KeyEvent e){
		
				switch (e.getKeyCode()){
				case KeyEvent.VK_W : up 	= true; break;
				case KeyEvent.VK_S : down	= true; break;
				case KeyEvent.VK_A : left	= true; break;
				case KeyEvent.VK_D : right 	= true; break;
				case KeyEvent.VK_T : 
					missileCD ++;
					if (missileCD % 2 == 0){
					handler.addObject(new Missile(player.x, player.y, 8, 16, missileSpeed));
					Music.popon();
					}
					break;
				case KeyEvent.VK_Y : handler.addObject(new Lazer(player.x, player.y, 12, 1000));
				}
			System.out.println("hi");
			update();
	}
				
		
	public void keyTyped(KeyEvent e){
		
		
	}
	
	public void keyReleased(KeyEvent e){
		
			switch (e.getKeyCode()){
			case KeyEvent.VK_W : up 	= false; break;
			case KeyEvent.VK_S : down	= false; break;
			case KeyEvent.VK_A : left	= false; break;
			case KeyEvent.VK_D : right 	= false; break;
			
			}
			
			update();

		}
	}

