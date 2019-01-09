package main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

import protocol.ChatProtocolImpl;

public class ServerMain {

	public static void main(String[] args) {
		
		try {
			Registry chatRegistry = LocateRegistry.createRegistry(5050);
			System.out.println("Server is running");
			chatRegistry.rebind("ChatServer", new ChatProtocolImpl());
		}
		catch(RemoteException e){
			Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, e);
		}

	}

}
