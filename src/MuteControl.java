

import java.io.IOException;

import javax.sound.sampled.*;

public class MuteControl {
	
	public static boolean mute = false;// true to mute the line, false to unmute
	
	public static void controller() throws LineUnavailableException, IOException{
			
		BooleanControl bc = (BooleanControl) MusicPlay.sourceDataLine.getControl
				(BooleanControl.Type.MUTE);
				if (bc != null) {
				    bc.setValue(mute); 
				}
		//Music.sourceDataLine.start();
	}
}
