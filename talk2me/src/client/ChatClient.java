package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import interfaces.ChatServerInterface;


public class ChatClient {
	
	public static void main(String[] args) throws NotBoundException,RemoteException, MalformedURLException {
		
		Scanner scanner  =  new Scanner(System.in);
		
		ChatServerInterface name = (ChatServerInterface) Naming.lookup("//localhost:1111/ChatServerInterface");
		System.out.println("Client is connected to Server \n");
		System.out.println("Gib deinen Namen ein:");
		
		String user;
		
		user = scanner.next();
		System.out.println("Server:" + name.sayName(user) );
		
	   
	  }

}
