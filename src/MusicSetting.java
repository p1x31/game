import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicSetting {

		private static JLabel label1;
		private static JLabel label2;
		private static JButton muteButton;
		
		public static void Setting(){
		{
			System.out.println("Buuton");
			JFrame frame = new JFrame("Audio Settings");
			frame.setSize(200,100);
			frame.setUndecorated(true);
			frame.getContentPane().setBackground(Color.DARK_GRAY);
			//frame.getContentPane().setVisible(false);
			
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Audio Settings");
			centreWindow(frame);
			JToggleButton toggleButton = new JToggleButton("Mute", false);
			ActionListener actionListener = new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent) {
			        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
			        boolean selected = abstractButton.getModel().isSelected();
			        MuteControl.setMute(selected);
			        MusicBGM.setMute(selected);
			        System.out.println("Action - selected=" + selected + "\n");
			      }
			};
			toggleButton.addActionListener(actionListener);
			 frame.add(toggleButton, BorderLayout.NORTH);

			
			//JLabel label1;
			label1 = new JLabel("SFX Vol");
			label1.setForeground(Color.white);
			
			frame.add(label1, BorderLayout.BEFORE_LINE_BEGINS);
			
			//Music Volume Slider
			JSlider slider = new JSlider(JSlider.HORIZONTAL,-60, 6, 0);
			
			//SilderListener
			slider.addChangeListener(new ChangeListener(){
				public void stateChanged(ChangeEvent event){
					float value = slider.getValue();
					VolumeControl.value = value;
				}
			});
			
			frame.add(slider, BorderLayout.CENTER);
			
			//SFX Volume Slider
			JPanel BGM = new JPanel(new BorderLayout());
			
			JSlider BGMSlider = new JSlider(JSlider.HORIZONTAL,-60, 6, 0);
			BGMSlider.addChangeListener(new ChangeListener(){
				public void stateChanged(ChangeEvent event){
					float value = BGMSlider.getValue();
					MusicBGM.value = value;
				}
			});
			//frame.add(SFXSlider, BorderLayout.AFTER_LAST_LINE);
			
			BGM.add(BGMSlider,BorderLayout.CENTER);
			label2 = new JLabel("Music Vol");
			label2.setForeground(Color.white);
			BGM.add(label2,BorderLayout.WEST);
			frame.add(BGM, BorderLayout.SOUTH);
			BGM.setBackground(Color.DARK_GRAY);
			//frame.add(label2, BorderLayout.BEFORE_LINE_BEGINS);
			
			
			//TemperatureComponent comp = new TemperatureComponent (temp, -1250, 1250, 0);
			//frame.add(comp);
			frame.setVisible(true);
		}}


		public static void centreWindow(Window frame) {
		    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 4);
		    frame.setLocation(x, y);
		}
		
}
