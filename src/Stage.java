
import java.util.Random;
import java.util.TimerTask;

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

		if(stage == 1) {
			generateWave1(stage);
			generateWave2();
			generateBoss();
		}
		else
		{
			for (int i = 0; i < stage; i ++){
			Random ran = new Random();
			int x = ran.nextInt(1560);
			int y = ran.nextInt(500);
			
			handler.addObject(new Enemy(20 + x, 10 + y, 128, 48, 3, handler));
			//handler.addObject(new Enemy2(20 +x, 20 +y, 18, 10, handler));
			//System.out.println(handler.object.size());
			for(int j = 0; j < handler.object.size(); j++)
			{
				GameObject temp = handler.object.get(j);
				if (temp.getId() == ID.Player)
				{
					Player tempPlayer = (Player) temp;
					//int playerY = tempPlayer.getY();
					//int playerX = tempPlayer.getX();
					handler.addObject(new Enemy4(20 + x, 20 + y, 20, 20, 2, tempPlayer));
				}
			}
			
		}
		}
		System.out.println("Stage " + stage);
		stage ++;
	}


	public void gameover(){
		System.out.println("Game Over");
	}
	
	public void generateWave1(int n)
	{
		switch(n)
		{
		case 1:
		java.util.Timer timer = new java.util.Timer(true); 
		TimerTask taske2 = new TimerTask(){
			public void run(){
				handler.addObject(new Enemy2(-10, 0, 10, 10, 3, 1, 10, handler));
				handler.addObject(new Enemy2(1580, 0, 10, 10,-3, 1, 10, handler));
			}
		};
		timer.schedule(taske2, 2000, 2000);
		TimerTask stop = new TimerTask(){
			public void run(){
				timer.cancel();
				timer.purge();
			}
		};
		timer.schedule(stop, 16000);
		break;
			
		}
	}
	
	public void generateWave2()
	{
		java.util.Timer timer = new java.util.Timer(true); 
		TimerTask taske4 = new TimerTask(){
			public void run(){
				for(int j = 0; j < handler.object.size(); j++)
				{
					GameObject temp = handler.object.get(j);
					if (temp.getId() == ID.Player)
					{
						Player tempPlayer = (Player) temp;
						//int playerY = tempPlayer.getY();
						//int playerX = tempPlayer.getX();
						handler.addObject(new Enemy4(100 , -100, 20, 20, 2, tempPlayer));
						handler.addObject(new Enemy4(1400 , -100, 20, 20, 2, tempPlayer));
					}
				}
			}
		};
		timer.schedule(taske4, 11000, 3000);
		TimerTask stop = new TimerTask(){
			public void run(){
				timer.cancel();
				timer.purge();
			}
		};
		timer.schedule(stop, 17000);
	}
	
	public void generateBoss()
	{
		java.util.Timer timer = new java.util.Timer(true); 
		TimerTask taskBoss = new TimerTask(){
			public void run(){
				for(int j = 0; j < handler.object.size(); j++)
				{
					GameObject temp = handler.object.get(j);
					if (temp.getId() == ID.Player)
					{
						Player tempPlayer = (Player) temp;
				        handler.addObject(new Enemy5(400, -100, 40, 30, 150, handler, tempPlayer));
					}
				}
			}
		};
		timer.schedule(taskBoss, 20000);
	}
}
