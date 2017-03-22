import java.net.ServerSocket;

/**
 * Created by Vadim on 28/01/2017.
 */
public class Server {

    public static final int PORT = 9047;

    public static void main(String[] args) throws Exception {
        System.out.println("GameNet server is running.");
        ServerSocket listener = new ServerSocket(PORT);
        try {
            GameNet gameNet = new GameNet();
            GameNet.Player p1 = gameNet.new Player(listener.accept(), "P1");
            GameNet.Player p2 = gameNet.new Player(listener.accept(), "P2");
            p1.setOpponent(p2);
            p2.setOpponent(p1);
            p1.start();
            p2.start();

        } finally {
            listener.close();
        }
    }
}
