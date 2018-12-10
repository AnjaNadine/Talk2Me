package server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfaces.ChatServerImplementation;


public class ChatServer {
	
	public static void main(String[] args) throws RemoteException,NotBoundException
    {
        try
        {
            Registry r = LocateRegistry.createRegistry(1111);
            r.rebind("ChatServerInterface", new ChatServerImplementation());
            System.out.println("Server is running");
        }
        catch(Exception e)
                {
                    System.out.println(e);
                }
    }
		
	
}
