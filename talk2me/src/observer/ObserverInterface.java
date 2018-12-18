package observer;

import java.rmi.RemoteException;

public interface ObserverInterface {
	
	void update(Object observable, Object updateMsg) throws RemoteException;

}
