package server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import client.ChatProtocol;

public class Server extends UnicastRemoteObject implements ChatProtocol {
	
	public Server() throws RemoteException {
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String sayName(String user) throws RemoteException {
		return "Welcome to Talk2Me : " + user;
	}
	
	public static void main(String[] args) throws RemoteException,NotBoundException
    {
        try
        {
            Registry r = LocateRegistry.createRegistry(1111);
            r.rebind("ChatProtocol", new Server());
            System.out.println("Server is running");
        }
        catch(Exception e)
                {
                    System.out.println(e);
                }
    }
	
   
}
