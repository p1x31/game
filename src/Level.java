import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Level {
	private Scanner m;
	public static final Integer Size = 41;
	public String Map[] = new String[Size];
	private Image space;
	public String path = "./res/";

	public Level(){
		ImageIcon img = new ImageIcon(path + "space.png");
		space = img.getImage();

		openFile();
		readFile();
		closeFile();
	}

	public Image getspace(){
		return space;
	}


	public String getMap(int x, int y){
		String index = Map[y].substring(x, x + 1);
		return index;
	}

	public boolean isspace(int x, int y){
		if(getMap(x, y).equals(BoardNet.spaceCharacter)){
			return true;
		}
		else{
			return false;
		}
	}


	public void openFile(){
		try{
			m = new Scanner(new File(path + "map_easy.txt"));
			System.out.println(m);
		}catch(Exception e){
			System.out.println("error loading map");
		}
	}

	public void readFile(){
		while(m.hasNext()){
			for(int i = 0; i < Size; i++){
				Map[i] = m.next();
			}
		}
	}

	public void setTile(int x, int y, String tile){
		char[] data = Map[y].toCharArray();
		data[x] = tile.toCharArray()[0];
		Map[y] = String.copyValueOf(data);
	}

	public void closeFile(){
	}
}