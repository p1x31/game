import java.awt.Graphics;
import java.util.LinkedList;




// TODO: Auto-generated Javadoc
/**
 * The Handler Class. 
 * Manages all the Objects
 */
public class Handler {
	
	/** The object list. */
	LinkedList<GameObject> object = new LinkedList<GameObject>();


	/**
	 * Tick.
	 * Updates every object
	 * If the object is expired, removes from the linked list
	 */
	public void tick(){
		for(int i = 0; i < object.size(); i ++){
			GameObject temp = object.get(i);
			if (temp.id == ID.PlayerProjectile){
				if (temp.expired){
					object.remove(i);
				}
			}
			temp.tick();
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
