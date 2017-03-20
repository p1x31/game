
import javax.sound.sampled.*;


public class VolumeControl {
	
	//Set volume value between "-20.0f" to "+6.0206f"(reduce 10db to increase 6db)
	public static float value = 0.0f;
	
	public static void controller() {
		try {
			MusicPlay.sourceDataLine.open(MusicPlay.audioFormat);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		FloatControl volume = (FloatControl) MusicPlay.sourceDataLine.getControl
				(FloatControl.Type.MASTER_GAIN);
		
		volume.setValue(value);
		
	}
	
	public static void setVolume(float v){
		value = v;
	}
}
