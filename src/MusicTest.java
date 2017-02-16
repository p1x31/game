
//import audio.*;

public class MusicTest {

	public static void main(String[] args) {
		
		/* Volume Control & Mute Control
		 * 
		 * Set volume value between "-20.0" to "+6.0206f"(reduce 20db to increase 6db)
		 * Use a slider in interface to change the volumeValue below 
		 * 
		 * Set Mute Control true or false
		 * 
		 * (To make sure both control work,
		 * Use these two variables before using the sounds effects below)
		 * 
		 */
		
		VolumeControl.value = 0.0f;
		MuteControl.mute = false;
		
		
		
		/* Sounds Effects
		 * 
		 * Each method is an indipendent music.
		 * 
		 * 1. put audioFile in src folder
		 * 
		 * 2. Uncomment one of method below to test the sounds.
		 *    If two or more music play simultaneously, 
		 *    it only plays the last one.(except background music)
		 * 
		 * 3. Use methods below and put them at where you need.
		 *    (Make sure import this package to your classes) 
		 * 
		 */
		
		Music.begin();
		//Music.satellite_noise();
		//Music.highScore();
		//Music.popon();
		//Music.potwak();
		//Music.gameover();
		//Music.cash_register();

		/*
		 * more music waiting for add..
		 * 
		 */
	}

}