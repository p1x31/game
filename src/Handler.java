import java.awt.Graphics;
import java.util.LinkedList;




// TODO: Auto-generated Javadoc
/**
 * The Handler Class. 
 * Manages all the Objects
 */

public class Handler {
	/** The board width. */
	private static final int width = 1600; 
	
	/** The board height. */
	private static final int height = width*9/12;
	/** The object list. */

	private Stage stage;
	public Boolean existEnemy;
	public Boolean alive = true;
	public Boolean gameover = false;
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	protected GameState state = GameState.Game;


	/**
	 * Tick.
	 * Updates every object
	 * If the object is expired, removes from the linked list
	 */

	
	
	public Handler(){

	}

	public void tick(){
		state = GameState.Game;
		existEnemy = false;
		alive = false;
//		System.out.println(object.size());
		for(int i = 0; i < object.size(); i ++){
			GameObject temp = object.get(i);
			
			
			
				//attempt of damaging enemy
				if (temp.getId() == ID.Enemy){
					existEnemy = true;
					for(int j = 0; j < object.size(); j++){
						if ((object.get(j).getId() != ID.Enemy) && (object.get(j).getId() != ID.Danmaku)){
							
							object.get(j).damageCheck(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
							temp.damageCheck(object.get(j).getX(), object.get(j).getY(), object.get(j).getWidth(), object.get(j).getHeight());
							
							
						}
					}
				}
				
				if (temp.getId() == ID.Player){
					alive = true;
					for(int j = 0; j < object.size(); j++){
						if ((object.get(j).getId() == ID.Danmaku) || (object.get(j).getId() == ID.Enemy)){
							temp.damageCheck(object.get(j).getX(), object.get(j).getY(), object.get(j).getWidth(), object.get(j).getHeight());
							object.get(j).damageCheck(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
							
						}
					}
				}
				
				//remove if object expired
				if (temp.isExpired()){
					object.remove(i);
				}

			
			temp.tick();
	
		}	
		if ((!existEnemy)&&(alive)){
			stage.nextStage();
			state = GameState.Stage;
		
			
		}
		if (!alive){
			while(object.size() > 0){
				object.remove(0);
			}
			stage.gameover();
			Music.gameover();
			
			state = GameState.Over;
			
		}
		
		
	}
	
	/**
	 * Render.
	 *
	 * @param g the g
	 */
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i ++){
			GameObject temp = object.get(i);
			temp.render(g);
		}
	}

	/**
	 * Adds the object.
	 *
	 * @param object the object
	 */
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	
	/**
	 * Removes the object.
	 *
	 * @param object the object
	 */
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	

	public void singleInit(){
		this.addObject(new Player(width/4, height*11/16, ID.Player,30, 30, 5, 1));
	//	this.addObject(new Player(width*3/4, height*11/16, ID.Player,16, 3, 2));
		
		stage = new Stage(this);
	}
	public void multiInit(){
		this.addObject(new Player(width/4, height*11/16, ID.Player,30, 30, 5, 1));
		this.addObject(new Player(width*3/4, height*11/16, ID.Player,30, 30, 3, 2));
		
		stage = new Stage(this);
	}

	public Player getPlayer(){
		return (Player) object.getFirst();
		
	}
	public int getStage(){
		return stage.getStage();
	}

	public GameState getState() {
		// TODO Auto-generated method stub
		return state;
	}

}
