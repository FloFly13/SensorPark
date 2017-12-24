package SensorPark;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

	private static ServerSocket server1;
	private static ServerSocket server2;
	private static ServerSocket server3;
	
    
	
	public static void main(String[] args) {
		
		
		
		Affichage affichageClient = new Affichage();
		affichageClient.start();
		
		
		
		Thread sensor1 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					//creation d'une socket
					server1 = new ServerSocket(7777);
					while(true){	    
					    Socket socket = server1.accept();
					    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					    String message = (String) ois.readObject();
					    System.out.println("Message Received from capteur1: " + message);
					    Affichage.textE1.setText(" ");
					    try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					    Affichage.textE1.setText(message);
					    //close resources
					    ois.close();
					    socket.close();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
	    
	    
	    Thread sensor2 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					//creation d'une socket
					server2 = new ServerSocket(7778);
					while(true){
					    
					    Socket socket = server2.accept();
					    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					    String message = (String) ois.readObject();
					    System.out.println("Message Received from capteur2: " + message);
					    Affichage.textE2.setText(" ");
					    try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					    Affichage.textE2.setText(message);
					    //close resources
					    ois.close();
					    socket.close();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
	    
		Thread sensor3 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					//creation d'une socket
					server3 = new ServerSocket(7779);
				
					while(true){
					    
					    Socket socket = server3.accept();
					    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					    String message = (String) ois.readObject();
					    System.out.println("Message Received from capteur3: " + message);
					    Affichage.textE3.setText(" ");
					    try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					    Affichage.textE3.setText(message);
					    //close resources
					    ois.close();
					    socket.close();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});

	    sensor1.start();
	    sensor2.start();
	    sensor3.start();
	    
    }

}




