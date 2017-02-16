import java.util.Random;

public class Stage {
	
	private int stage;
	private Handler handler;
	public Stage(Handler handler){
		this.handler = handler;
		stage = 1;
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	public void nextStage(){
		for (int i = 0; i < stage; i ++){
			Random ran = new Random();
			int x = ran.nextInt(1560);
			int y = ran.nextInt(500);/**
			for(int j = 0; j < 10; j++)
			{
			handler.addObject(new Enemy(20*j + x, 10*j + y, 16, 3, handler));
			}
			*/
			handler.addObject(new Enemy(20 + x, 10 + y, 16, 3, handler));
			//handler.addObject(new Enemy2(20 + x, 20 + y, 18, 10, handler));
			//handler.addObject(new Enemy4(20 + x, 20 + y, 20, 2));
		}
		System.out.println("Stage " + stage);
		stage ++;
	}
	public void gameover(){
		System.out.println("Game Over");
	}
}
