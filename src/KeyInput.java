import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		System.out.println(handler.object.size());
		for (int i = 0; i < handler.object.size(); i++){
			GameObject temp = handler.object.get(i);
				if (temp.getId() == ID.Player){
					Player tempPlayer = (Player) temp;
					if (tempPlayer.getNoPlayer() == 1){
					if (key == KeyEvent.VK_W){
						tempPlayer.setVelY(-5);
					}
					if (key == KeyEvent.VK_S){
						tempPlayer.setVelY(5);
					}if (key == KeyEvent.VK_A){
						tempPlayer.setVelX(-5);
					}if (key == KeyEvent.VK_D){
						tempPlayer.setVelX(5);
					}if (key == KeyEvent.VK_T){
				
						handler.addObject(new Missile(temp.x, temp.y, 8));
						Music.potwak();
					}
					if (key == KeyEvent.VK_Y){

						handler.addObject(new Lazer(temp.x, temp.y, 8));
					}
					}
				}
			}
		}
		
	public void keyTyped(KeyEvent e){
		
		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++){
			GameObject temp = handler.object.get(i);
				if (temp.getId() == ID.Player){
					Player tempPlayer = (Player) temp;
					if (tempPlayer.getNoPlayer() == 1){
					if (key == KeyEvent.VK_W){
						temp.setVelY(0);
					}
					if (key == KeyEvent.VK_S){
						temp.setVelY(0);
					}if (key == KeyEvent.VK_A){
						temp.setVelX(0);
					}if (key == KeyEvent.VK_D){
						temp.setVelX(0);
					}if (key == KeyEvent.VK_T){
						temp.setSize(16);
					}if (key == KeyEvent.VK_Y){
						temp.setSize(16);
					}
					}
				}
			}
	}
	
}
