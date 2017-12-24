package SensorPark;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Serveur {

	private static File fichier;
	static Scanner sc;
	Thread Sensor1,Sensor2, Sensor3;
	
	public Serveur() {
		
		fichier = new File("data.txt");

		
		Sensor1 = new Sensor1(1, 8000, 180);
		Sensor2 = new Sensor2(2, 5000, 180);
		Sensor3 = new Sensor3(3, 10000, 180);
		
	}
	
	
	public void startServer() throws FileNotFoundException {
		
		Sensor1.start();
		Sensor2.start();
		Sensor3.start();
		
	}
	
	
	public static synchronized String getDataFromFile(int nbLine) throws Exception {
		
		try {
			sc = new Scanner(fichier);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int i = 0;
		String res = null;

		while(sc.hasNext()) {
			String tmp = sc.nextLine();
			
			if(i== nbLine) {
				res = tmp;
			}
			i++;
		}
		if (res == null) {
				throw new Exception("Mauvais format de fichier");
		}
		return res;
	}
	
	public static String filtre1(String s) {
	
		if (s.charAt(s.length()-1) == '0') {
			return "NOTHING";
		} else {
			return "DETECTE";
		} 
	}
	
	public static String filtre2(String s, int etat, int oldEtat) {
		
		if(etat != oldEtat) {
			return s;
		}
		else return "NA";
	}

	
}
