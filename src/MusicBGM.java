
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;

public class MusicBGM {
	public static void BGMPlayer(){
		System.out.println("Playing BGM");
		JFrame frame = new JFrame("BGM Player");
		frame.setSize(200,50);
		frame.setVisible(false);
		try{
    		System.out.println("Playing");
            URL cb;
            File f = new File("src/audioFile/BGM.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.play();
    	}catch (MalformedURLException e) {
            System.out.println("no music");
        	e.printStackTrace();
        }
	}
}
