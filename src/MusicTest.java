

public class MusicTest {

	public static void main(String[] args) {
		
		/* Volume Control & Mute Control
		 * 
		 * There are two variable in charge of volume control and mute control respectively.
		 * Set volume value between "-60.0" to "+6.0206f"(reduce 60db to increase 6db)
		 * Set Mute Control true or false
		 * 
		 * There is a complete interface of Music Settings in the class MusicSetting.java
		 * I have already put 'MusicSetting.Setting();' as a plug-in in Menu.java
		 * You can click option -> music setting in main program to test it.
		 * 
		 */
		
		VolumeControl.value = 0.0f;
		MuteControl.mute = false;
		//MusicSetting.Setting(); This won't be working here, because of threads need.
		
		
		
		/* Sounds Effects
		 * 
		 * Each method is an indipendent music.
		 * 
		 * 1. put audioFile in src folder
		 * 
		 * 2. Uncomment one of method below to test the sounds.
		 * 
		 * 3. Use methods below and put them at where you need.
		 *    (Make sure import this package to your classes) 
		 * 
		 */
		
		//Music.begin();
		Music.BGM();
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