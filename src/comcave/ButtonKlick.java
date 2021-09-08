package comcave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ButtonKlick implements ActionListener{
	Window w;

	public ButtonKlick(Window window) {
		this.w = window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(  e.getSource().equals( w.btnSpeichern )   ) {
			Kunde.kundenListe.add(new Kunde(
					w.cbAnrede.getSelectedItem().toString(),
					w.tfVorname.getText(),
					w.tfNachname.getText(),
					w.tfAnschrift.getText(),
					w.tfPlz.getText(),
					w.tfOrt.getText(),
					w.tfTelefon.getText(),
					w.cbxNeukunde.isSelected()
			));
			
			DateiManager.kundenSpeichern();
			
		}else if(  e.getSource().equals( w.btnShowKunde )  ) {
			w.taKundenAnzeige.setText(""); // TextArea leeren
			String text = "";
			for(Kunde kunde : Kunde.kundenListe) {
				text += kunde.getAnrede() + " " + kunde.getVorname() + " " + kunde.getNachname() + "\n";
			}
			w.taKundenAnzeige.setText(text);
		}
	}

}
