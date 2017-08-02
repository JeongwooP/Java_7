import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GuguImpl extends UnicastRemoteObject implements GuguInter {
	public GuguImpl() throws RemoteException {

	}

	@Override
	public int[] dan(int d) throws RemoteException {
		int su[] = new int[9];
		for (int i = 1; i < 10; i++) {
			su[i - 1] = d * i;
		}
		return su;
	}

	@Override
	public String test() throws RemoteException {
		return "Rmi server 주인장 : 박정우";
	}
}
