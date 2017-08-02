import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer1Impl extends UnicastRemoteObject implements RmiServer1Interface{
	public RmiServer1Impl() throws RemoteException{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String sayHello(String name) throws RemoteException {
		System.out.println(name + "님 서버방문을 환영합니다");
		return name + "님 자바를 떠나보내며";
	}
}
