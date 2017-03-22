
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


// TODO: Auto-generated Javadoc

/**
 * The Class GameNet.
 */
public class GameNet {

	public class Player extends Thread {
		private Socket socket;
		private String playerName;
		BufferedReader input;
		PrintWriter output;
		Player opponent;
		int x, y;

		public Player(Socket socket, String playerName) {
			this.socket = socket;
			this.playerName = playerName;
			log("New connection with # " + playerName + " at " + socket);
			try {
				input = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				output = new PrintWriter(socket.getOutputStream(), true);
				output.println("WELCOME " + playerName);
				output.println("MESSAGE Waiting for opponent to connect");
			} catch (IOException e) {
				System.out.println("PlayerNet died: " + e);
			}
		}

		public void setOpponent(Player opponent) {
			this.opponent = opponent;
		}

		public void run() {
			try {
				//Start the game!
				output.println("START");

				String response;
				// Get messages from the client
				while (true) {
					response = input.readLine();
					if (response.startsWith("POS")) {
						log("Client response:" + response);
						String data[] = response.split("\\s");
						int pos_x = Integer.parseInt(data[2]);
						int pos_y = Integer.parseInt(data[3]);
						if (data[1].equals(playerName)) {
							x = pos_x;
							y = pos_y;
						} else {
							opponent.x = pos_x;
							opponent.y = pos_y;
						}

						//Handling player collisions
						if (x == opponent.x && y == opponent.y) {
								output.println("END TIE! Both players hit each other.");
								opponent.output.println("END TIE! Both players hit each other.");
						}

						output.println(response);
						opponent.output.println(response);
					}
				}
			} catch (IOException e) {
				log("Error handling client# " + playerName + ": " + e);
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					log("Couldn't close a socket, what's going on?");
				}
				log("Connection with client# " + playerName + " closed");
			}
		}

		private void log(String message) {
			System.out.println(message);
		}
	}
}

