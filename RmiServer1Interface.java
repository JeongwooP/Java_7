import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiServer1Interface extends Remote{
	String sayHello(String name) throws RemoteException;
}
