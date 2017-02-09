import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;




// TODO: Auto-generated Javadoc
/**
 * The Handler Class. 
 * Manages all the Objects
 */
public class Handler {
	
	/** The object list. */
	static LinkedList<GameObject> object = new LinkedList<GameObject>();
	/**
	 * Tick.
	 * Updates every object
	 * If the object is expired, removes from the linked list
	 */
	public void tick(){
		
		for(int i = 0; i < object.size(); i ++){
			GameObject temp = object.get(i);
			
				//attempt of damaging enemy
				if (temp.id == ID.Enemy){
					for(int j = 0; j < object.size(); j++){
						if (temp.id != ID.Enemy){
							temp.damageCheck(temp.getX(), temp.getY());
						}
					}
				}
				
				//remove if object expired
				if (temp.expired){
					object.remove(i);
				}
			temp.tick(object);
			
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
	


}
