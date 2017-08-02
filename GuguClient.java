import java.rmi.Naming;

public class GuguClient {
	public static void main(String[] args) {
		try {
			GuguInter guguInter = (GuguInter) Naming.lookup("rmi://192.168.0.17:1099/good");
			

			int re[] = guguInter.dan(5);
			for (int i = 0; i < re.length; i++) {
				System.out.println("5 * " + (i + 1)  + " = " + re[i]);
			}
			
			System.out.println("\n" + guguInter.test());
		} catch (Exception e) {
			System.out.println("RmiClient err : " + e);
		}
	}

}
