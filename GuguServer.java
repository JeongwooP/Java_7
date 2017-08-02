import java.rmi.Naming;

public class GuguServer {
	public static void main(String[] args) {
		try {	
		GuguImpl impl = new GuguImpl();
		Naming.rebind("rmi://192.168.0.17:1099/good", impl);
		System.out.println("바인딩 성공");
		} catch (Exception e) {
			System.out.println("server err:" + e);
		}
	
	}
}
