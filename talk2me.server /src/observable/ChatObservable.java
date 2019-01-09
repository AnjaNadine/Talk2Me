package observable;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import observer.ChatObserver;

public class ChatObservable{
	
	private ArrayList<ChatObserver> talk2meClientList = new ArrayList<>();
	
	public void addChatObserver(ChatObserver cO){
		
		talk2meClientList.add(cO);
	}
	
	public void removeChatObserver(ChatObserver cO){
		
		talk2meClientList.remove(cO);
	}
	
	public void notifyClients(String msg) throws RemoteException{
		
		for (ChatObserver client: talk2meClientList){
			
			new Thread(){
				public void run(){
					try {
						client.update(msg);
					}
					catch (RemoteException e){
						Logger.getLogger(ChatObservable.class.getName()).log(Level.SEVERE, null, e);
					}
				}

			}.start();
			
		}
	}

}
