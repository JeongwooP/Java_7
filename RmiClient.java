import java.rmi.Naming;

public class RmiClient {

	public static void main(String[] args) {
		try {
			RmiServer1Interface rs = (RmiServer1Interface)Naming.lookup("rmi://192.168.0.17:1099/nice");
			String msg = rs.sayHello("박정우");
			System.out.println("호출 결과:" + msg);
		} catch (Exception e) {
			System.out.println("RmiClient err : " + e);
		}
	}
}
