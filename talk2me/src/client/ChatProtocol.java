package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatProtocol extends Remote{
	
	String sayName(String user) throws RemoteException;
	//String getMsg(String msg) throws RemoteException;
	//String setText(String text) throws RemoteException;

}
