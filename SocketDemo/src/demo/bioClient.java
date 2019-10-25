import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class bioClient {
	public static void main(String []args) {
		String host = null;
		int port = 0;
		
		for (int i=0;i<args.length;i++) {
			System.out.println(i+"_"+args[i]);
		}
		
		
		if(args.length>=2) {
			host = args[0];
			port = Integer.parseInt(args[1]);
		}else {
			host = "127.0.0.1";
			port = 9999;
		}
		
		Socket socket = null;
		BufferedReader reader = null;
		PrintWriter writer = null;
		
		Scanner s = new Scanner(System.in);
		
		try {
			
			socket = new Socket(host,port);
			String message = null;
			
			reader= new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			writer = new PrintWriter(socket.getOutputStream(),true);
			
			while(true) {
				message = s.nextLine();
				
				if (message.equals("exit")) {
					break;
				}
				
				writer.println(message);
				writer.flush();
				
				System.out.println(reader.readLine());
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if (socket!=null) {
				try {
					socket.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				socket = null;
				
				if (reader!=null) {
					try {
						reader.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				reader=null;
				
				if (writer!=null) {
					try {
						writer.close();
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				writer=null;
			}
		}
		
	}
}
