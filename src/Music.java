
import java.applet.AudioClip;
import java.io.*;
import java.applet.Applet;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;


/**
 * 
 * @author Yi Liu
 * @version 4.0
 *
 */

public class Music extends Frame {

	public static String fileName = null;
	
	public static void satellite_noise(){
		fileName = "satellite_noise.wav";
		MusicPlay.play();
	}
	
	public static void popon(){
		fileName = "popon.wav";
		MusicPlay.play();
	}
	
	public static void gameover(){
		fileName = "gameover.wav";
		MusicPlay.play();
	}
	
	public static void begin(){
		fileName = "ccbegin.wav";
		MusicPlay.play();
	}
	
	public static void potwak(){
		fileName = "potwak.wav";
		MusicPlay.play();
	}
	
	public static void highScore(){
		fileName = "highScore.wav";
		MusicPlay.play();
	}
	
	public static void cash_register(){
		fileName = "cash_register.wav";
		MusicPlay.play();
	}
	
	public static void BGM(){
		fileName = "BGM.wav";
		MusicPlay.play();
	}

}
