import java.rmi.Naming;

public class RmiServer {

	public static void main(String[] args) {
		try {	
		RmiServer1Impl impl = new RmiServer1Impl();
		Naming.rebind("rmi://192.168.0.17:1099/nice", impl);
		System.out.println("바인딩 성공");
		} catch (Exception e) {
			System.out.println("server err:" + e);
		}
	
	}

}
