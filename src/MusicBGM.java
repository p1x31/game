import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;

public class MusicBGM {
	public static boolean mute = false;
	public static float value = 0.0f;
	static boolean isStop = true;
	static boolean hasStop = true;
	static AudioInputStream audioInputStream;
	static SourceDataLine sourceDataLine;
	static AudioFormat audioFormat;
	/**
	 * BGM player.
	 * This is a background music player.
	 */
	public static void BGMPlayer(){
		System.out.println("Playing BGM");
		JFrame frame = new JFrame("BGM Player");
		frame.setSize(1,1);
		frame.setVisible(false);
		
		/*
		try{
    		System.out.println("Playing");
            
    		URL cb;
            File f = new File("src/audioFile/BGM.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.play();
            
          
            if(mute == true){
            	aau.stop();
            }
            
    	}catch (Exception e) {
            System.out.println("wrong");
        	e.printStackTrace();
        }*/
		
		try{
		
	    AudioInputStream audioIn = AudioSystem.getAudioInputStream(
	    		new File("src/audioFile/BGM.wav"));
	    	
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioIn);

	    clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		FloatControl gainControl = 
		    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(value);
		if(mute == true){
        	clip.stop();
        }
		Thread.sleep(1000000);
		}
		catch (Exception e){
			System.out.println("wrong");
		}
		
	}/*
		public static void play() {
        try {
        	isStop = true;// stop playing thread
        	
            // waiting for playing stop

            System.out.print("src/audioFile/BGM.wav");

            while (!hasStop) {
            	try {
                    Thread.sleep(10);
                } catch (Exception e) {

                }

            }

            System.out.println("");
            
            File file = new File("src/audioFile/BGM.wav");

            
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

            //VolumeControl.controller();
            //MuteControl.controller();
            sourceDataLine.start();

            // create a thread to play
            isStop = false;
            Thread MusicBGMThread = new Thread(new MusicBGMThread());
            MusicBGMThread.start();
            

        	} catch (Exception e) {
        		
            e.printStackTrace();
        }
	}*/
	public static void setMute(boolean m){
		mute = m;
	}
}
