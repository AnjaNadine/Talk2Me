package connection;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.Naming;

import protocol.ChatProtocol;

public class ServerConnect{
	
	private static ServerConnect serverConnect;
	private ChatProtocol chatProtocol;
	
	
	private ServerConnect() throws RemoteException, NotBoundException, MalformedURLException{
		chatProtocol = (ChatProtocol) Naming.lookup("//localhost:5050/ChatServer");
	}
	
	public static ServerConnect getServerConnect() throws RemoteException, NotBoundException, MalformedURLException{
		
		if(serverConnect == null){
			serverConnect = new ServerConnect();
		}		
		return serverConnect;		
	}

	public ChatProtocol getChatProtocol(){
		return chatProtocol;
	}

}

