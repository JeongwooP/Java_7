

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class NetTest2 {

	public static void main(String[] args) {
		try {
			InetAddress ia = InetAddress.getByName("www.daum.net");
			Socket socket = new Socket(ia, 80);
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
			out.println("GET http://www.daum.net");
			out.flush(); 	//요청 후 버퍼를 클리어
			
			//서버에서 넘어온 자료 출력
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){
				String str = reader.readLine();
				if(str == null) break;
				System.out.println(str);
			}
			reader.close();
			out.close();
			socket.close();
		} catch (Exception e) {
			System.out.println("err:" + e);
		}

	}

}
