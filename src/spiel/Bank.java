package spiel;
import java.util.Vector;


public class Bank {

	private double kontostand;
	private Vector<Kredit> alleKredite = new Vector<Kredit>();
	private Kredit kredit1 = null;
	private Kredit kredit2 = null;
	
	public double getKontostand(){
		return kontostand;
	}
	/** Gibt alle Kredite als Array zurück **/
	public Kredit[] getAlleKredite(){
		Kredit[] kredite = new Kredit[alleKredite.size()];
		for (int i = 0; i < alleKredite.size(); i++){
			kredite[i] = alleKredite.get(i);
		}
		return kredite;
	}

	/** KONSTRUKTOR **/
	public Bank() {
		kontostand = Planspiel.getStartKontostand();
	}
	
	/** Kontostand um den übergebenen Betrag erhöhen **/
	public void kontostandErhoehen(double wert){
		kontostand += wert;
	}
	
	/** Kontostand um den übergebenen Betrag verringern **/
	public void kontostandVerringern(double wert){
		kontostand -= wert;
	}
	
	/**
	 * Methode wird in der Klasse UI in der Methode updateUI() aufgerufen.
	 * Methode berechnet die Kreditkonditionen. Nur bei positivem Cashflow gilt das Unternehmen als kreditwürdig und hat Anspruch auf einen Kredit.
	 * Macht ein Unternehmen Verluste und hat einen negativen Cashflow wird es keinen Kredit bekommen.
	 * Ist der CashflowVorZins positiv, wird allerdings nach Abzug der Zinsen (für momentan laufende Kredite) negativ, bekommt das Unternehmen auch keinen Kredit.
	 * Der berechnete Kredit wird im Objekt Bank gespeichert.
	 * @param laufzeit Lauzzeit des Kredits in Monaten.
	 * @param nr Nummer des Kredits, es gibt Kredit1 und Kredit2.
	 * @return Gibt den berechneten Kredit zurück. 
	 */
	public Kredit berechneKredit(int nr, int laufzeit, double zinsSatz){
		double durchschnittsCashflowVorZins = Planspiel.getAktuellesUnternehmen().getDurchschnittsCashflowVorZins(); // kann durchschnittlich pro Monat zur tilgung genutzt werden
		
		Kredit[] kredite = getAlleKredite();
		double zinsen = 0;
		double tilgung = 0;
		for (int i = 0; i < kredite.length; i++){
			tilgung += kredite[i].getTilgung();
			zinsen += kredite[i].getDurchschnitsZinsen();
		}
		
		double zurTilgungVerfuegbar = durchschnittsCashflowVorZins - tilgung - zinsen;
		
		/**
		 * kreditSumme wird mit dem Faktor 0.3 berechnet.
		 * Kredite sollen nicht direkt 100% des zur Tilgung zur Verfügung stehenden Kapitals aufbrauchen.
		 * Bei Bedarf kann der Spieler mehrere Kredite nehmen
		 */ 
		double kreditSumme = zurTilgungVerfuegbar * laufzeit * 0.3; 
		if (kreditSumme > 20000){ // Kredit muss mindestens 20000€ betragen
			switch(nr) {
				case  1: 
					kredit1 = new Kredit(this, (int) Math.round(kreditSumme), zinsSatz, laufzeit);
					return kredit1;
				case  2:
					kredit2 = new Kredit(this, (int) Math.round(kreditSumme), zinsSatz, laufzeit);
					return kredit2;
			}
		}
		
		kredit1 = null;
		kredit2 = null;
		return null;
	}
	
	/**
	 * Der zuvor berechnete Kredit (durch die Methode berechneKredit()) wird genommen.
	 * Der Kredit, der genommen wird, ist im Objekt Bank gespeichert. 
	 * @param nr Nummer des Kredits, es gibt Kredit1 und Kredit2.
	 */
	public void kreditNehmen(int nr){
		switch(nr) {
			case  1: 
				if (kredit1 == null) break;
				alleKredite.add(kredit1); 
				Planspiel.getAktuellesUnternehmen().getBank().kontostandErhoehen(kredit1.getKreditSumme());
				break;
			case  2:
				if (kredit2 == null) break;
				alleKredite.add(kredit2);
				Planspiel.getAktuellesUnternehmen().getBank().kontostandErhoehen(kredit2.getKreditSumme());
				break;
		}
	}
	
	/**
	 * Methode wird zu Beginn jeden Zugs in der Methode neuerZug() in der Klasse Unternehmen aufgerufen.
	 * Alle laufenden Kredite werden getilgt.
	 */
	public void krediteTilgen(){
		int i = 0;
		while (i < alleKredite.size()){
			alleKredite.get(i).tilgung();
			if (alleKredite.get(i).isKreditGetilgt())
				alleKredite.removeElementAt(i);
			else i++; // i nur erhöhen wenn kein Element gelöscht wurde
		}
	}
}
