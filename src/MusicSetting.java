import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MusicSetting {

		private static JLabel label1;
		private static JButton muteButton;
		
		public static void Setting(){
		{
			System.out.println("Buuton");
			JFrame frame = new JFrame("Audio Settings");
			frame.setSize(200,50);
			frame.setUndecorated(true);
			//frame.getContentPane().setBackground(Color.DARK_GRAY);
			frame.getContentPane().setVisible(false);
			
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Audio Settings");
			centreWindow(frame);
			JToggleButton toggleButton = new JToggleButton("Mute", false);
			ActionListener actionListener = new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent) {
			        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
			        boolean selected = abstractButton.getModel().isSelected();
			        MuteControl.setMute(selected);
			        System.out.println("Action - selected=" + selected + "\n");
			      }
			};
			toggleButton.addActionListener(actionListener);
			 frame.add(toggleButton, BorderLayout.NORTH);

			
			//JLabel label1;
			label1 = new JLabel("Volume");
			label1.setForeground(Color.white);
			frame.add(label1, BorderLayout.WEST);
			
			
			//Volume Slider
			JSlider slider = new JSlider(JSlider.HORIZONTAL,-20, 6, 0);
			
			//SilderListener
			slider.addChangeListener(new ChangeListener(){
				public void stateChanged(ChangeEvent event){
					float value = slider.getValue();
					VolumeControl.value = value;
				}
			});
			
			frame.add(slider, BorderLayout.CENTER);
			
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
		
		public void stateChanged(ChangeEvent e) {
		    JSlider slider = (JSlider)e.getSource();
		    if (!slider.getValueIsAdjusting()) {
		        VolumeControl.value = (float)slider.getValue();
		        
		    }
		}
		

}
