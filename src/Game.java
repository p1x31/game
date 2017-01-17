import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferStrategy;

import javax.swing.AbstractAction;
import javax.swing.InputMap;
import javax.swing.KeyStroke;




public class Game extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1649015221280660791L;
	/**
	 * 
	 */
	private static final int width = 640; 
	private static final int height = width*9/12;
	private Handler handler;

	
	private boolean running = false;
	private Thread thread;

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
		handler = new Handler();
	}
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	@Override
	public void run()
    {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
                    long now = System.nanoTime();
                    delta += (now - lastTime) / ns;
                    lastTime = now;
                    while(delta >=1)
                            {
                                tick();
                                delta--;
                            }
                            if(running)
                                render();
                            frames++;
                            
                            if(System.currentTimeMillis() - timer > 1000)
                            {
                                timer += 1000;
                                System.out.println("FPS: "+ frames);
                                frames = 0;
                            }
        }
                stop();
    }
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	private void tick() {
		handler.tick();
	}
	public Game() {
		handler = new Handler();

		new Board(width, height, "TPA", this);

//		Player player1 = new Player(width/4, height*11/16, ID.Player1,16);
//		Player player2 = new Player(width*3/4, height*11/16, ID.Player2,16);

		handler.addObject(new Player(width/4, height*11/16, ID.Player1,16, 3));
		handler.addObject(new Player(width*3/4, height*11/16, ID.Player2,16, 3));
		this.addKeyListener(new KeyInput(handler));
	}

	public static void main(String[] args) {
		new Game();
		
	}
	

	

}
