package comcave;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DateiManager {

	
	
		public static void kundenSpeichern() {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("kunden.comcave"));
				oos.writeObject(Kunde.kundenListe);
				oos.close();
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		
		public static void kundenLaden() {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("kunden.comcave"));
				Kunde.kundenListe = (ArrayList<Kunde>)ois.readObject();
				ois.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
}
