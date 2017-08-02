

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class NetTest3Server {

	public static void main(String[] args) {
		//네트워크 서버
		ServerSocket ss = null;
		Socket socket = null;
		
		//내 컴이 사용 중인 port number 확인
		/*for (int i = 0; i < 65536; i++){
			try {
				ss = new ServerSocket(i);
				ss.close();
			} catch (Exception e) {
				System.out.println(i + "번 port번호 사용 가능");
			}
		}
		System.out.println("확인 종료"); */
		// try {
		// ss = new ServerSocket(port)
		// } catch (Exception e) {
		// System.out.println("서버 에러:" + e);
		// }
		
	 try {
		ss = new ServerSocket(9999);
		System.out.println("서버 서비스 중...");
		socket = ss.accept();
		System.out.println("접속자 정보:" + socket.toString());
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String data = reader.readLine();
		System.out.println("수신자료:" + data);
		reader.close();
		socket.close();
		ss.close();
	} catch (Exception e) {
		System.out.println("서버 에러:" + e);
	}
	}

}
