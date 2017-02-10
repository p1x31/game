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
			int x = ran.nextInt(600);
			int y = ran.nextInt(210);
			handler.addObject(new Enemy(20 + x, 10 + y, 16, 3));
			System.out.println("Stage " + stage);
		}
		System.out.println("Stage " + stage);
		stage ++;
	}
	
}
