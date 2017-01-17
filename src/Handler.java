import java.awt.Graphics;
import java.util.LinkedList;




public class Handler {
	LinkedList<GameObject> object = new LinkedList<GameObject>();


	public void tick(){
		for(int i = 0; i < object.size(); i ++){
			GameObject temp = object.get(i);
			if (temp.id == ID.Danmaku){
				if (temp.expired){
					object.remove(i);
				}
			}
			temp.tick();
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i ++){
			GameObject temp = object.get(i);
			temp.render(g);
		}
	}

	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObeject(GameObject object){
		this.object.remove(object);
	}

}
