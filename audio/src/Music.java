import java.applet.AudioClip;
import java.io.*;
import java.applet.Applet;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.net.URL;
 
public class Music extends Frame{
	
    //public static String audioPath = System.getProperty("/Users/yiliu/Documents/BHAM/Year2/Semester2/TeamProject/audio/");
	public static String audioPath = "/Users/yiliu/Documents/BHAM/Year2/Semester2/TeamProject/audio/";
    public Music(){
    /*try {
    		System.out.println("Playing");
            URL cb;
            //File f = new File(imagePath+"mario.midi");
            //File f = new File(imagePath+"1000.ogg");
            //File f = new File(imagePath+"Passenger.mp3");
            File f = new File("/Users/yiliu/Documents/BHAM/Year2/Semester2/TeamProject/audio/cash_register.wav");
            //File f = new File("/Users/yiliu/Documents/BHAM/1.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.play();//loop aau.play() single audio aau.stop()stop play
            //aau.loop();
 
        } catch (MalformedURLException e) {
            System.out.println("no music");
        	e.printStackTrace();
        }*/
    }
    
    public void BGM(){
    	try{
    		System.out.println("Playing");
            URL cb;
            //File f = new File(imagePath+"mario.midi");
            //File f = new File(imagePath+"1000.ogg");
            //File f = new File(imagePath+"Passenger.mp3");
            File f = new File("/Users/yiliu/Documents/BHAM/Year2/Semester2/TeamProject/audio/cash_register.wav");
            //File f = new File("/Users/yiliu/Documents/BHAM/1.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.play();//loop aau.play() single audio aau.stop()stop play
            //aau.loop();
    	}catch (MalformedURLException e) {
            System.out.println("no music");
        	e.printStackTrace();
        }
    }
    
    public static void cash_register_bgm(){
    	try{
    		System.out.println("Playing");
            URL cb;
            File f = new File(audioPath + "cash_register.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.play();//loop aau.play() single audio aau.stop()stop play
            //aau.loop();
    	}catch (MalformedURLException e) {
            System.out.println("no music");
        	e.printStackTrace();
        }
    }
    
    public void score_board_bgm(){
    	try{
    		System.out.println("Playing");
            URL cb;
            //File f = new File(imagePath+"mario.midi");
            //File f = new File(imagePath+"1000.ogg");
            //File f = new File(imagePath+"Passenger.mp3");
            File f = new File(audioPath + "score_board.wav");
            //File f = new File("/Users/yiliu/Documents/BHAM/1.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.play();
            //aau.stop();
            //loop aau.play() single audio aau.stop(); stop play
            //aau.loop();
    	}catch (MalformedURLException e) {
            System.out.println("no music");
        	e.printStackTrace();
        }
    }
    
    public void potwak_bgm(){
    	try{
    		System.out.println("Playing");
            URL cb;
            File f = new File(audioPath + "POTWAK.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.play();//loop aau.play() single audio aau.stop()stop play
            aau.loop();
    	}catch (MalformedURLException e) {
            System.out.println("no music");
        	e.printStackTrace();
        }
    }

   
    
	public static void play() {
		// TODO Auto-generated method stub
		new Music();
		
	}
	
	
	public static void bgm(){
		Music m = new Music();
		m.BGM();
	}
	
	public static void cash_register(){
		Music m = new Music();
		m.cash_register_bgm();
	}
	
	
	public static void score_board(){
		Music m = new Music();
		m.score_board_bgm();
	}
	
	public static void potwak(){
		Music m = new Music();
		m.potwak_bgm();
	}
	
}
