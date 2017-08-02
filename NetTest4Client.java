import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class NetTest4Client {
	Socket socket;
	PrintWriter out;
	BufferedReader reader;
	
	public NetTest4Client() {
		try {
			socket = new Socket("192.168.0.17", 8888);
			out = new PrintWriter(socket.getOutputStream(), true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "euc-kr"));
		} catch (Exception e) {
			System.out.println("NetTest4Client err : " + e);
		}
	}
	
	public void sendMsg(){
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("전송 메세지 입력: ");
			String data = scanner.nextLine();
			out.println(data);	//서버로 자료 전송
			
			String re_data = reader.readLine();
			System.out.println("수신자료는 " + re_data);
			
		} catch (Exception e) {
			System.out.println("sendMsg err : " + e);
		}
	}
	
	public static void main(String[] args) {
		NetTest4Client client = new NetTest4Client();
		client.sendMsg();
	}

}
