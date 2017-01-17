import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;





// TODO: Auto-generated Javadoc
/**
 * The Class Game.
 */
public class Game extends Canvas implements Runnable{

	/** The Constant serialVersionUID. */
	//got this for serial warning suspression
	private static final long serialVersionUID = 1649015221280660791L;
	
	/** The board width. */
	private static final int width = 640; 
	
	/** The board height. */
	private static final int height = width*9/12;
	
	/** The handler. */
	private Handler handler;

	
	/** Check if the game is running. */
	private boolean running = false;
	
	/** The thread. */
	private Thread thread;

	/**
	 * Start.
	 */
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
		handler = new Handler();
	}
	
	/**
	 * Stop.
	 */
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
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
	
	/**
	 * Render.
	 */
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
	
	/**
	 * Tick.
	 * Handler updates the state of all objects
	 */
	private void tick() {
		handler.tick();
	}
	
	/**
	 * Instantiates a new game.
	 */
	public Game() {
		handler = new Handler();

		new Board(width, height, "TPA", this);

//		Player player1 = new Player(width/4, height*11/16, ID.Player1,16);
//		Player player2 = new Player(width*3/4, height*11/16, ID.Player2,16);

		handler.addObject(new Player(width/4, height*11/16, ID.Player1,16, 3));
		handler.addObject(new Player(width*3/4, height*11/16, ID.Player2,16, 3));
		this.addKeyListener(new KeyInput(handler));
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new Game();
		
	}
	

	

}
