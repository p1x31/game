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
import javax.sound.sampled.SourceDataLine;


/**
 * 
 * @author Yi Liu
 * @version 3.0
 *
 */

public class Music extends Frame {
	
	static boolean isStop = true;
	static boolean hasStop = true;
	static AudioInputStream audioInputStream;
	static SourceDataLine sourceDataLine;
	static AudioFormat audioFormat;
	

	public static String audioPath = "src/audioFile/";	
    
	/*
	 * Comment content is Audio file version 2
	 * 
	
	public Music(){

    try {
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
        }
    	play();
    }*/
    
    /*
    public void BGM(){
    	try{
    		System.out.println("Playing");
            URL cb;
            File f = new File(audioPath + "satellite_noise.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.play();//loop aau.play() single audio aau.stop()stop play
            //aau.loop();
            //aau.stop();
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
    
    public void highScore_bgm(){
    	try{
    		System.out.println("Playing");
            URL cb;
            File f = new File(audioPath + "highScore.wav");
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
            File f = new File(audioPath + "potwak.wav");
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
    
    public void begin_bgm(){
    	try{
    		System.out.println("Playing");
            URL cb;
            File f = new File(audioPath + "ccbegin.wav");
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
    
    public void gameover_bgm(){
    	try{
    		System.out.println("Playing");
            URL cb;
            File f = new File(audioPath + "gameover.wav");
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
    
    public void popon_bgm(){
    	try{
    		System.out.println("Playing");
            URL cb;
            File f = new File(audioPath + "popon.wav");
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
    
    public void satellite_noise_bgm(){
    	try{
    		System.out.println("Playing");
            URL cb;
            File f = new File(audioPath + "satellite_noise.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.play();//loop aau.play() single audio aau.stop()stop play
            //aau.loop();
    	}catch (MalformedURLException e) {
            System.out.println("no music");
        	e.printStackTrace();
        }
    }*/


	
	/*
	public static void highScore(){
		Music m = new Music();
		m.highScore_bgm();
	}
	
	public static void potwak(){
		Music m = new Music();
		m.potwak_bgm();
	}
	
	public static void begin(){
		Music m = new Music();
		m.begin_bgm();
	}*/
	

	public static String fileName = null;
	
	public static void satellite_noise(){
		fileName = "satellite_noise.wav";
		play();
	}
	
	public static void popon(){
		fileName = "popon.wav";
		play();
	}
	
	public static void gameover(){
		fileName = "gameover.wav";
		play();
	}
	
	public static void begin(){
		fileName = "ccbegin.wav";
		play();
	}
	
	public static void potwak(){
		fileName = "potwak.wav";
		play();
	}
	
	public static void highScore(){
		fileName = "highScore.wav";
		play();
	}
	
	public static void cash_register(){
		fileName = "cash_register.wav";
		play();
	}
	
	
    private static void play() {
   
        try {
        	isStop = true;// stop playing thread

            // waiting for playing stop
            System.out.print("Play:" + fileName);

            while (!hasStop) {
            	try {
                    Thread.sleep(10);
                } catch (Exception e) {

                }

            }

            System.out.println("");
            
            File file = new File(audioPath + fileName);

            // getting input stream
            audioInputStream = AudioSystem.getAudioInputStream(file);
            audioFormat = audioInputStream.getFormat();
            
            // MP3 file translation
            if (audioFormat.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {

                audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                		audioFormat.getSampleRate(), 16, audioFormat.getChannels(), 
                		audioFormat.getChannels() * 2,audioFormat.getSampleRate(), false);

                audioInputStream = AudioSystem.getAudioInputStream(audioFormat,audioInputStream);
            }

            // output
            DataLine.Info dataLineInfo = new DataLine.Info(
                    SourceDataLine.class, audioFormat,
                    AudioSystem.NOT_SPECIFIED);

            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

            // create thread to play
            isStop = false;
            Thread MusicThread = new Thread(new MusicThread());
            MusicThread.start();
        	} catch (Exception e) {

            e.printStackTrace();

        }
        
    }

}
