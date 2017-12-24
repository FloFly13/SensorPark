package SensorPark;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class Sensor1 extends Thread {

	private int id;
	private int frequence;
	private int range;
	private Timer t;
	
	private String currentData;
	private String afterProcessing;
	
	
	public Sensor1(int id, int frequence, int range) {
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
		    		
		    		currentData = Serveur.getDataFromFile(0);
		    		afterProcessing = Serveur.filtre1(currentData);
		    		
		            Socket socket = null;
		            ObjectOutputStream oos = null;

	                
	                socket = new Socket("127.0.0.1", 7777);
	                oos = new ObjectOutputStream(socket.getOutputStream());
	                System.out.println("[Capteur1] : Sending data to client");
	                
	                oos.writeObject("" + afterProcessing);

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
