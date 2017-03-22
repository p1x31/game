import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

	private JFrame frame;
	private Game game;
	private int width = 1600;
	private int height = 1000;
	static boolean hardmode;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Menu window = new Menu();
				 Menu window = new Menu();
				 
				//	window.frame.setVisible(true);
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
		Music.begin();
		frame = new JFrame("D4 Game");
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setBounds( 0, 0, width, height);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		centreWindow(frame);
		
	/*	Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("/img/cursor.png");
		Cursor c = toolkit.createCustomCursor(image , new Point(frame.getX(), 
		           frame.getY()), "img");
		frame.setCursor (c); */
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		JButton btnSinglePlayer = new JButton("Single Player");
		btnSinglePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game = new Game((width-4), (height-50));
				game.getHandler().singleInit();
				MusicBGM.BGMPlayer();
				game.addKeyListener(new KeyInput(game.getHandler()));
				if(game.isRunning()){
					btnSinglePlayer.setEnabled(false);
				} else {
					btnSinglePlayer.setEnabled(true);
					initialize();
					System.out.println("Stopped");
				}

			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/header.png")).getImage();
		panel.add(btnSinglePlayer);
		
		
		
		
		JPanel multisetup = new JPanel();
		multisetup.setBackground(Color.DARK_GRAY);
		multisetup.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		multisetup.setVisible(false);
		
		JToggleButton btnMultiplayer = new JToggleButton("Multiplayer");
		btnMultiplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(multisetup.isVisible()){
					multisetup.setVisible(false);
				} else {
					multisetup.setVisible(true);
				}
			}
		});
		panel.add(btnMultiplayer);
		panel.add(multisetup);


		JButton btnSearch = new JButton("Search opponent");
		btnSearch.addActionListener(e -> {
			int temp = (Math.random() <= 0.5) ? 1 : 2;
			if (temp == 1){
				try {
					Client.run();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else{
				try {
					Client2.run();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			multisetup.setVisible(false);
		});
		multisetup.add(btnSearch);



		/*JButton btnJoin = new JButton("Join Game");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game = new Game((width-4), (height-50));
				game.getHandler().multiInit();

				if(game.isRunning()){
					btnMultiplayer.setEnabled(false);
				} else {
					btnMultiplayer.setEnabled(true);
				}
				multisetup.setVisible(false);
			}
		});
		multisetup.add(btnJoin);
		
		JButton btnHost = new JButton("Host Game");
		btnHost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game = new Game((width-4), (height-50));
				game.getHandler().multiInit();
				
				if(game.isRunning()){
					btnMultiplayer.setEnabled(false);
				} else {
					btnMultiplayer.setEnabled(true);
				}
				multisetup.setVisible(false);
			}
		});
		multisetup.add(btnHost);*/
		

		
		JPanel options = new JPanel();
		options.setBackground(Color.DARK_GRAY);
		options.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		options.setVisible(false);
		
		JToggleButton btnOptions = new JToggleButton("Options");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(options.isVisible()){
					options.setVisible(false);			
				} else {
					options.setVisible(true);
				}

			}
		});
		panel.add(btnOptions);
		panel.add(options);
		
		JToggleButton tglbtnMute = new JToggleButton("Music Setting");
		options.add(tglbtnMute);
		tglbtnMute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusicSetting.Setting();

			}
		});
		
		JToggleButton tglbtnDifficulty = new JToggleButton("Hard Mode");
		tglbtnDifficulty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tglbtnDifficulty.isSelected()){
					hardmode = true;
				} else { hardmode = false;
				}
			}
		});
		
		options.add(tglbtnDifficulty);
		

		
		JLabel lblHeader = new JLabel("");
		frame.getContentPane().add(lblHeader, BorderLayout.NORTH);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setVerticalAlignment(SwingConstants.TOP);
		lblHeader.setIcon(new ImageIcon(img));
		frame.setVisible(true);
	}
	
	public boolean getHardMode(){
		return hardmode;
	}

	
	
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}

}