

import java.io.PrintWriter;
import java.net.Socket;

public class NetTest3Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 9999);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println("Hi I'm jeongwoo" + "/n");//서버로 자료 전송
			out.close();
			socket.close();
		} catch (Exception e) {
			System.out.println("클라이언트 에러" + e);
		}
	

	}

}
