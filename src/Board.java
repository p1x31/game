import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Board {

	/**
	 * Instantiates a new board. JFrame stuff 
	 * mostly template code
	 *
	 * @param width the width
	 * @param height the height
	 * @param title the title
	 * @param game the game
	 */
	private JFrame frame;
	public Board(int width, int height, String title, Game game) {
		frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setUndecorated(true); // Hide the frame controls and border
		frame.setVisible(true);
		game.start();
		
	}
	public void dispatch(){
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
}
