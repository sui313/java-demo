import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.ServerCloneException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class bioServer {
	public static void main(String[] args) {
		int port = getPort(args);

		ServerSocket server = null;
		//exectorService service = Executors.newfixedTreadPool(50);
		ExecutorService service = Executors.newFixedThreadPool(50);

		try {
			server = new ServerSocket(port);
			System.out.println("server started!");

			while (true) {
				Socket socket = server.accept();

				service.execute(new Handler(socket));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (server  != null) {
				try {

					server.close();

				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				server = null;
			}
		}
	}

	static class Handler implements Runnable {
		Socket socket = null;

		public Handler(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			BufferedReader reader = null;
			PrintWriter writer = null;

			try {
				
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

				writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

				String readMessage = null;

				while (true) {
					System.out.println("server reading...");

					if ((readMessage = reader.readLine()) == null) {
						break;
					}

					System.out.println(readMessage);
					writer.println("server recive :" + readMessage);
					writer.flush();
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				socket = null;
				if (reader != null) {
					try {
						reader.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				reader = null;

				if (writer != null) {
					writer.close();
				}
				writer = null;
			}
		}
	}

	private static int getPort(String[] args) {
		if (args.length > 0) {
			try {
				return Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				return 9999;
			}
		} else {
			return 9999;
		}
	}

}
