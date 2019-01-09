package protocol;

import java.rmi.Remote;
import java.rmi.RemoteException;

import observer.ChatObserver;

public interface ChatProtocol extends Remote{
	
	public void addChatObserver(ChatObserver cO) throws RemoteException;
	public void removeChatObserver(ChatObserver cO) throws RemoteException;
	public void sendMessage(String msg) throws RemoteException;

}
