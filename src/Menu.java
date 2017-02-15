import java.awt.EventQueue;
import java.awt.Image;
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

public class Menu {

	private JFrame frame;
	private Game game;
	private int width = 1600;
	private int height = 1000;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
				
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Menu() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame("D4 Game");
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setBounds( 0, 0, width, height);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		centreWindow(frame);
		ImageIcon header = new ImageIcon("http://i.imgur.com/6ndL97D.png");
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		JButton btnSinglePlayer = new JButton("Single Player");
		btnSinglePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game = new Game(width-4, height-50);
				game.setLocation((frame.getX()+width),(frame.getY()+height));
				game.getHandler().singleInit();
				
				
				if(game.isRunning()){
					btnSinglePlayer.setEnabled(false);
				} else {
					btnSinglePlayer.setEnabled(true);
				}

			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/header.png")).getImage();
		panel.add(btnSinglePlayer);
		
		JButton btnMultiplayer = new JButton("Multiplayer");
		btnMultiplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game = new Game(width, height);
				game.getHandler().multiInit();
				
				if(game.isRunning()){
					btnMultiplayer.setEnabled(false);
				} else {
					btnMultiplayer.setEnabled(true);
				}

			}
		});
		panel.add(btnMultiplayer);
		
		JButton btnOptions = new JButton("Options");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnOptions);
		
		JLabel lblHeader = new JLabel("");
		frame.getContentPane().add(lblHeader, BorderLayout.NORTH);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setVerticalAlignment(SwingConstants.TOP);
		lblHeader.setIcon(new ImageIcon(img));

	}
	
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}

}