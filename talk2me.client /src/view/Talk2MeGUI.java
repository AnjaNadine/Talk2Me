package view;

import javax.swing.JFrame;

import connection.ServerConnect;
import observer.ChatObserver;
import protocol.ChatProtocol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Talk2MeGUI extends JFrame{

	private static final long serialVersionUID = 1L;
	private ChatObserver chatObserver;
    private JButton exitButton;
    private JScrollPane jScrollPane1;
    private JTextField messageText;
    private JTextArea messageTextArea;
	
	public Talk2MeGUI(String name){
		
		setTitle(name);
		initComponents();
		setVisible(true);
	}
	
	private void initComponents(){
		

        jScrollPane1 = new JScrollPane();
        messageTextArea = new JTextArea();
        messageText = new JTextField();
        exitButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent closeEvent) {
                formWindowClosed(closeEvent);
            }
        });

        messageTextArea.setColumns(20);
        messageTextArea.setRows(5);
        jScrollPane1.setViewportView(messageTextArea);

        messageText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent msgEvent) {
            	msgActionEvent(msgEvent);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent exitEvent) {
                exitActionEvent(exitEvent);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageText)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageText, GroupLayout.PREFERRED_SIZE, 39,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
	}
	
	public void msgActionEvent(ActionEvent msgEvent){
		
		try{
			ChatProtocol chatProtocol = ServerConnect.getServerConnect().getChatProtocol();
			chatProtocol.sendMessage(getTitle() + " : " + messageText.getText());
			messageText.setText("");
		}
		
		catch(RemoteException | NotBoundException |MalformedURLException e) {
			
			Logger.getLogger(Talk2MeGUI.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public void exitActionEvent(ActionEvent exitEvent){
		
		ChatProtocol chatProtocol;
		
		try{
			chatProtocol = ServerConnect.getServerConnect().getChatProtocol();
			chatProtocol.removeChatObserver(this.chatObserver);
			dispose();
		}
		
		catch(RemoteException | NotBoundException |MalformedURLException e) {
			
			Logger.getLogger(Talk2MeGUI.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
    private void formWindowClosed(WindowEvent evt){
        try {
            ChatProtocol chatProtocol = ServerConnect.getServerConnect().getChatProtocol();
            chatProtocol.removeChatObserver(this.chatObserver);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Talk2MeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    public void setMessage(String msg){
    	messageTextArea.append(msg + "\n");
    }
	
	

}
