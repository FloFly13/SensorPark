package SensorPark;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class Sensor3 extends Thread {

	private int id;
	private int frequence;
	private int range;
	private Timer t;
	
	private String currentData;
	private String afterProcessing;
	
	
	public Sensor3(int id, int frequence, int range) {
		this.id = id;
		this.frequence = frequence;
		this.range = range;
		
		t = new Timer();
	}
	
	public void run() {
		
		t.schedule(new TimerTask() {
		    @Override
		    public void run() {
		    	try {
		    		
		    		currentData = Serveur.getDataFromFile(2);
		    		
		            Socket socket = null;
		            ObjectOutputStream oos = null;

	                //establish socket connection to server
	                socket = new Socket("127.0.0.1", 7779);
	                //write to socket using ObjectOutputStream
	                oos = new ObjectOutputStream(socket.getOutputStream());
	                System.out.println("[Capteur3] : Sending data to client");
	                
	                oos.writeObject("" + currentData);

	                //close resources
	                oos.close();
	                Thread.sleep(100);
	                socket.close();	
		    		
		    	} catch (Exception e) {
		    		e.printStackTrace();
		    	}
		    }
		}, 0, frequence);
		
		
	}
}
