import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Vadim on 28/01/2017.
 */
public class Client {

    private static Socket socket;
    private static BufferedReader in;
    private static PrintWriter out;
    private static String playerName;
    private static BoardNet boardNet;
    public static int new_x = 0, new_y = 0;

   public static void run()

   {
       try {
           // amazon aws ec2 address
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
                           boardNet.m.setTile(new_x, new_y, BoardNet.spaceCharacter);
                           boardNet.p.moveOpponent(new_x, new_y);
                       }
                   }
                   if (response.startsWith("START")) {
                       log("START command came from server. Initializing the map");
                       out.print(playerName + " started!");
                       //initialize the boardNet
                       JFrame frame = new JFrame("TPA GameNet");
                       frame.setTitle("Multiplayer TPA GameNet");
                       //problem with the boardNet (needs to be created with right parameters)
                       boardNet = new BoardNet(out, playerName);
                       frame.add(boardNet);
                       frame.setSize(Level.Size * 20, (Level.Size + 1) * 20 + 40);
                       frame.setLocationRelativeTo(null);
                       frame.setVisible(true);
                       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   }
                   if (response.startsWith("END")) {
                       log("GAME is over! " + response);
                       boardNet.finishGame(response.replace("END ", ""));
                       socket.close();
                   }
               }
           } finally {
               socket.close();
           }
       } catch(Exception e){}
}

    private static void log(String message) {
        System.out.println(message);
    }

}
