package observer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import view.Talk2MeGUI;

public class ChatObserverImpl extends UnicastRemoteObject implements ChatObserver{
	
	private static final long serialVersionUID = 1L;
	private Talk2MeGUI gui;
	public ChatObserverImpl(Talk2MeGUI gui) throws RemoteException{
		
		this.gui = gui;
	}

	@Override
	public void update(String msg) throws RemoteException{
		gui.setMessage(msg);
		
	}

}
