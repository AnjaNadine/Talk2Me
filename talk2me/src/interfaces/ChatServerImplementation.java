package interfaces;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatServerImplementation extends UnicastRemoteObject implements ChatServerInterface{
	

	public ChatServerImplementation() throws RemoteException {
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String sayName(String user) throws RemoteException {
		return "Welcome to Talk2Me : " + user;
	}

	
}
