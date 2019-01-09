package protocol;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import observable.ChatObservable;
import observer.ChatObserver;

public class ChatProtocolImpl extends UnicastRemoteObject implements ChatProtocol{

	private static final long serialVersionUID = 1L;
	private ChatObservable chatObservable = new ChatObservable(); 
	
	public ChatProtocolImpl() throws RemoteException{

 }

	@Override
	public void addChatObserver(ChatObserver cO) throws RemoteException{
		
		chatObservable.addChatObserver(cO);	
	}

	@Override
	public void removeChatObserver(ChatObserver cO) throws RemoteException{
		
		chatObservable.removeChatObserver(cO);	
	}

	@Override
	public void sendMessage(String msg) throws RemoteException{
		
		chatObservable.notifyClients(msg);	
	}
}
