import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class menu {

	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu window = new menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public menu() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("D4 Game");
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setBounds( 0, 0, 1600, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		centreWindow(frame);
		JLabel lblHeader = new JLabel("");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setIcon(new ImageIcon("/Users/Hugh/Documents/Team Project/menutext.png"));
		frame.getContentPane().add(lblHeader, BorderLayout.NORTH);
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton btnSinglePlayer = new JButton("Single Player");
		btnSinglePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnSinglePlayer);
		
		JButton btnMultiplayer = new JButton("Multiplayer");
		btnMultiplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnMultiplayer);
		
		JButton btnOptions = new JButton("Options");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnOptions);
	}
	
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}

}