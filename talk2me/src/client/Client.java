package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
	

	public static void main(String[] args) throws NotBoundException,RemoteException, MalformedURLException {
		
		Scanner scanner  =  new Scanner(System.in);
		
		ChatProtocol name = (ChatProtocol) Naming.lookup("//localhost:1111/ChatProtocol");
		System.out.println("Client is connected to Server \n");
		System.out.println("Gib deinen Namen ein: ");
		
		String user;
		
		user = scanner.next();
		System.out.println(name.sayName(user) );
		
	   
	  }


}
