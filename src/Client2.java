import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Vadim on 28/01/2017.
 */
public class Client2 {
    public static int new_x = 0, new_y = 0;
    private static Socket socket;
    private static BufferedReader in;
    private static PrintWriter out;
    private static String playerName;
    private static BoardNet board;
    public static void run() throws Exception {
        String serverAddress = "127.0.0.1";
        // Setup networking
        socket = new Socket(serverAddress, Server.PORT);
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        String response;
        try {
            while (true) {
                response = in.readLine();
                //log everything coming from server
                if (response != null) {
                    log("server response:" + response);
                }
                if (response.startsWith("WELCOME")) {
                    //show welcome screen
                    log("Welcome to the game! Click to start");
                    String data[] = response.split("\\s");
                    playerName = data[1];
                    log("player:" + playerName);
                }
                if (response.startsWith("WAIT")) {
                    log("Waiting for other player to connect");
                }
                if (response.startsWith("POS")) {
                    log("Opponent Moved!" + response);
                    String data[] = response.split("\\s");
                    if (!data[1].equals(playerName)) {
                        new_x = Integer.parseInt(data[2]);
                        new_y = Integer.parseInt(data[3]);
                        board.m.setTile(new_x, new_y, board.spaceCharacter);
                        board.p.moveOpponent(new_x, new_y);
                    }
                }
                if (response.startsWith("START")) {
                    log("START command came from server. Initializing the map");
                    out.print(playerName + " started!");
                    //initialize the board
                    JFrame frame = new JFrame("TPA GameNet");
                    frame.setTitle("Multiplayer TPA GameNet");
                    //problem with the board (needs to be created with right parameters)
                    board = new BoardNet(out, playerName);
                    frame.add(board);
                    frame.setSize(Level.Size*20, (Level.Size+1)*20 + 40);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
                if (response.startsWith("END")) {
                    log("GAME is over! " + response);
                    board.finishGame(response.replace("END ", ""));
                    socket.close();
                }
            }
        } finally {
            socket.close();
        }
    }
    private static void log(String message) {
        System.out.println(message);
    }


}