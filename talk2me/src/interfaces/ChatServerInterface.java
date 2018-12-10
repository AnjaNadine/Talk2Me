package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServerInterface extends Remote {
	
	String sayName(String user) throws RemoteException;

}
