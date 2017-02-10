import java.awt.Graphics;
import java.util.LinkedList;




// TODO: Auto-generated Javadoc
/**
 * The Handler Class. 
 * Manages all the Objects
 */

public class Handler {
	/** The board width. */
	private static final int width = 640; 
	
	/** The board height. */
	private static final int height = width*9/12;
	/** The object list. */

	private Stage stage;
	private Boolean existEnemy;
	LinkedList<GameObject> object = new LinkedList<GameObject>();



	/**
	 * Tick.
	 * Updates every object
	 * If the object is expired, removes from the linked list
	 */

	
	
	public Handler(){
		this.initialize();
	}

	public void tick(){
	
		existEnemy = false;
		for(int i = 0; i < object.size(); i ++){
			GameObject temp = object.get(i);
			
			
				//attempt of damaging enemy
				if (temp.id == ID.Enemy){
					existEnemy = true;
					for(int j = 0; j < object.size(); j++){
						if ((object.get(j).id != ID.Enemy) && (object.get(j).id != ID.Danmaku)){
							if (temp.damageCheck(object.get(j).getX(), object.get(j).getY(), object.get(j).getSize())){
							object.get(j).damageCheck(temp.getX(), temp.getY(), temp.getSize());
							}
						}
					}
				}
				
				if (temp.id == ID.Player){
					for(int j = 0; j < object.size(); j++){
						if ((object.get(j).id == ID.Danmaku) || (object.get(j).id == ID.Enemy)){
							if (temp.damageCheck(object.get(j).getX(), object.get(j).getY(), object.get(j).getSize())){
							object.get(j).damageCheck(temp.getX(), temp.getY(), temp.getSize());
							}
						}
					}
				}
				
				//remove if object expired
				if (temp.expired){
					object.remove(i);
				}

			
			
			temp.tick();
	
		}	
		if (!existEnemy){
			stage.nextStage();
			
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
	

	public void initialize(){
		this.addObject(new Player(width/4, height*11/16, ID.Player,16, 5, 1));
		this.addObject(new Player(width*3/4, height*11/16, ID.Player,16, 3, 2));
		
		stage = new Stage(this);
	}



}
