package main;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import connection.ServerConnect;
import observer.ChatObserver;
import observer.ChatObserverImpl;
import protocol.ChatProtocol;
import view.Talk2MeGUI;

public class ClientMain{

	public static void main(String[] args){
		
		try {
		
		String name = JOptionPane.showInputDialog(null, "Enter your name:");
		Talk2MeGUI gui = new Talk2MeGUI(name);
		ChatObserverImpl chatObservImpl = new ChatObserverImpl(gui);
		ChatProtocol chatProtocol = ServerConnect.getServerConnect().getChatProtocol();
		chatProtocol.addChatObserver((ChatObserver)chatObservImpl);
		}
		catch(RemoteException | NotBoundException |MalformedURLException e){
			
			Logger.getLogger(ClientMain.class.getName()).log(Level.SEVERE, null, e);
		}
		

	}

}
