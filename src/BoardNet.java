import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.PrintWriter;

public class BoardNet extends JPanel implements ActionListener {
    public static final String spaceCharacter = "_";
    private static final long serialVersionUID = 1649015221280660791L;
    public static final String spaceShipCharacter = "*";
    public String Message = "Scores ?";
    public boolean end = false;
    public Level m;
    public PlayerNet p;
    private Timer timer;
    private Font font = new Font("Times", Font.BOLD, 30);
    public BoardNet(PrintWriter out, String playerName) {
        m = new Level();
        p = new PlayerNet(playerName);
        //addKeyListener(new KeyInput(Handler handler));
        addKeyListener(new Al(out));
        setFocusable(true);
        timer = new Timer(25, this);
        timer.start();
    }
    public void finishGame(String message) {
        end = true;
        Message = message;
        repaint();
    }
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    public void paint(Graphics g) {
        super.paint(g);
        if (!end) {
            for (int y = 0; y < Level.Size; y++) {
                for (int x = 0; x < Level.Size; x++) {
                    if (m.getMap(x, y).equals(spaceCharacter)) {
                        g.drawImage(m.getspace(), x * 20, y * 20, null);
                    }
                    if (m.getMap(x, y).equals(spaceShipCharacter)) {
                        g.drawImage(m.getship(), x * 20, y * 20, null);
                    }
                }
                g.drawImage(p.getPlayer(), p.getX() * 20, p.getY() * 20, null);
                g.drawImage(p.getOpponent(), p.getOpX() * 20, p.getOpY() * 20, null);
                g.setColor(Color.BLACK);
                g.setFont(font);
            }
        }else{
            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString(Message, 10, 400);
        }
    }
    public class Al extends KeyAdapter {
        PrintWriter out;
        public Al(PrintWriter out) {
            // TODO Auto-generated constructor stub
            this.out = out;
        }
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            int offset_x = 0;
            int offset_y = 0;
            if (keycode == KeyEvent.VK_UP) {
                offset_y = -1;
            }
            if (keycode == KeyEvent.VK_DOWN) {
                offset_y = 1;
            }
            if (keycode == KeyEvent.VK_LEFT) {
                offset_x = -1;
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                offset_x = 1;
            }
            int new_x = p.getX() + offset_x;
            int new_y = p.getY() + offset_y;
            out.println("POS " + p.name + " " + new_x + " " + new_y + " ");
            if(m.isSpaceShip(new_x,new_y)){
                p.win = true;
            }
            m.setTile(new_x, new_y, BoardNet.spaceCharacter);
            p.move(offset_x, offset_y);
        }
        public void keyReleased(KeyEvent e) {
        }
        public void keyTyped(KeyEvent e) {
        }
    }
}