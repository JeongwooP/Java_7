

import java.net.InetAddress;

public class NetTest1 {
	public static void main(String[] args) {
		InetAddress ia;
		InetAddress ia2[];
		
		try {
			ia = InetAddress.getByName("www.naver.com");
			System.out.println(ia);
			System.out.println(ia.getHostAddress());
			System.out.println(ia.getHostName());
			
			System.out.println("--------");
			ia = InetAddress.getLocalHost();
			System.out.println(ia.getHostAddress());
			System.out.println(ia.getHostName());
			
			System.out.println("--------");
			ia2 = InetAddress.getAllByName("www.daum.net");
			System.out.println(ia2.length);
			for(InetAddress a:ia2){
				System.out.println(a.getHostAddress());
			}
			
		} catch (Exception e) {
			System.out.println("에러 : " + e);
		}
	}
}
