import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GuguInter extends Remote{
	int[] dan(int d) throws RemoteException;
	String test() throws RemoteException;
}
